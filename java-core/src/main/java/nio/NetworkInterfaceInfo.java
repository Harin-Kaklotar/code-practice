package com.lijujohn.nio;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by liju on 4/5/16.
 */
public class NetworkInterfaceInfo {
    public static void main(String[] args) {
        try {
            final Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Network display name : "+networkInterface.getDisplayName());
                System.out.println("Network name : "+networkInterface.getName());
                System.out.println("Network interface "+networkInterface.getDisplayName()+" isUp ? : "+networkInterface.isUp());
                System.out.println("Network interface"+networkInterface.getDisplayName()+" supports multicast ? : "+networkInterface.supportsMulticast());
                System.out.println("Network interface"+networkInterface.getDisplayName()+" isVirtual ? : "+networkInterface.isVirtual());
                System.out.println("Network interface"+networkInterface.getDisplayName()+" isLoopback ? : "+networkInterface.isLoopback());
                System.out.println("Network interface"+networkInterface.getDisplayName()+" isPointToPoint ? : "+networkInterface.isPointToPoint());
                Enumeration enumIP = networkInterface.getInetAddresses();
                while (enumIP.hasMoreElements()) {
                    InetAddress ip = (InetAddress) enumIP.nextElement();
                    System.out.println("IP address:" + ip);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
