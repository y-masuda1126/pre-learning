package pro.kensait.java.advanced.lsn_6_1_3.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Main_Multi {
    public static void main(String[] args) {
        try (
                // ServerSocketChannelをオープンする
                ServerSocketChannel ssc = ServerSocketChannel.open()) {

            // ソケットアドレス（ポート番号）をバインドする
            ssc.bind(new InetSocketAddress(55555));

            while (true) {
                System.out.println("start accept");
                SocketChannel socketChannel = ssc.accept(); // ここで受信を待機する
                new Thread(new ServerTask(socketChannel)).start();
                System.out.println("finish accept");
            }

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}