package com.lijujohn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by liju on 4/5/16.
 */
public class SingleThreadNonBlockingServer {

    private Map<SocketChannel, Queue<byte[]>> socketChannelQueueMap = new ConcurrentHashMap();
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private void startEchoServer() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));
            serverSocketChannel.configureBlocking(false);
            // serverSocketChannel.setOption(StandardSocketOptions.SO_SNDBUF,512*1024);
            // serverSocketChannel does not support SO_SNDBUF
            serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 512 * 1024);
            serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            final Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();// blocking call
                final Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    if (selectionKey.isAcceptable()) {
                        acceptConnection(selector, selectionKey);
                    }
                    if (selectionKey.isReadable()) {
                        read(selectionKey);
                    }
                    if (selectionKey.isWritable()) {
                        write(selectionKey);
                    }
                    selectionKeys.remove(selectionKey);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            final Queue<byte[]> queue = socketChannelQueueMap.get(socketChannel);

            byte[] bytes;
            while ((bytes = queue.peek()) != null) {
                socketChannel.write(ByteBuffer.wrap(bytes));
                queue.poll();
            }
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }

    private void read(SelectionKey selectionKey) throws IOException {

        if (selectionKey.isValid()) {
            final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            byteBuffer.clear();
            int bytesRead = socketChannel.read(byteBuffer);
            if (bytesRead == -1) {
                // channel is closed
                socketChannel.close();
                socketChannelQueueMap.remove(selectionKey);
                selectionKey.cancel();
                return;
            }

            byte[] bytes = new byte[bytesRead];
            System.arraycopy(byteBuffer.array(), 0, bytes, 0, bytesRead);
            socketChannelQueueMap.get(socketChannel).add(bytes);
            // socketChannel.register(selector,SelectionKey.OP_WRITE);
            selectionKey.interestOps(SelectionKey.OP_WRITE);// same key now used for new interest
        }
    }

    private void acceptConnection(Selector selector, SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            final SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("accepted connection from client ip - " + socketChannel.getRemoteAddress());
            socketChannel.configureBlocking(false);
            socketChannel.setOption(StandardSocketOptions.SO_SNDBUF, 512 * 1024);
            socketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 512 * 1024);
            socketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            socketChannel.register(selector, SelectionKey.OP_READ);
            socketChannelQueueMap.put(socketChannel, new ConcurrentLinkedDeque<byte[]>());
        }
    }

    public static void main(String[] args) {
        SingleThreadNonBlockingServer singleThreadNonBlockingServer = new SingleThreadNonBlockingServer();
        singleThreadNonBlockingServer.startEchoServer();
    }


}
