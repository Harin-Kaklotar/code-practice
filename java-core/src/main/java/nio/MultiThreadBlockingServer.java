package com.lijujohn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadBlockingServer {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(true);
            while(true){
                final SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("accepted connection from :"+socketChannel.getRemoteAddress());

                executorService.submit(new Worker(socketChannel));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
class Worker implements Runnable{
    private SocketChannel socketChannel = null;

    public Worker(SocketChannel sc){
        this.socketChannel = sc;
    }
    @Override public void run() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

            while (socketChannel.read(byteBuffer)!=-1){
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                if(byteBuffer.hasRemaining()){
                    byteBuffer.compact();
                }else {
                    byteBuffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
