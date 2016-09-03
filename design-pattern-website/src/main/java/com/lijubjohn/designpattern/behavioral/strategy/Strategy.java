package com.lijubjohn.designpattern.behavioral.strategy;

/**
 * Created by liju on 8/29/16.
 */
public class Strategy {
}

//Compressor interface
interface Compressor {
    public byte[] compress (byte[] bytes);
}

//Uses Gzip strategy for compression
class Gzip implements Compressor {
    @Override public byte[] compress(byte[] bytes) {
        return null;// implements gzip compression algo
    }
}
//Uses Snappy strategy for compression
class Snappy implements Compressor {
    @Override public byte[] compress(byte[] bytes) {
        return null;//implements snappy compression algo
    }
}

//Class uses compressor , note  - the class uses interface of compressor, implementation can vary
class PayloadCompressor {
    private Compressor compressor;

    public PayloadCompressor(Compressor compressor) {
        this.compressor = compressor;
    }

    public void compress(byte[] bytes){
        final byte[] compressed = compressor.compress(bytes);
        //do other stuff
    }
}
//Client class
class Client{
    public static void main(String[] args) {
        byte[] bytes = new String("Very long message").getBytes();
        final PayloadCompressor payloadCompressor1 = new PayloadCompressor(new Gzip());
        final PayloadCompressor payloadCompressor2 = new PayloadCompressor(new Snappy());
        payloadCompressor1.compress(bytes);
        payloadCompressor2.compress(bytes);
    }
}