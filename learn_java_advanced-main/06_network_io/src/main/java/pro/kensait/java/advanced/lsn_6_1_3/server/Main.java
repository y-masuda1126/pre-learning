package pro.kensait.java.advanced.lsn_6_1_3.server;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (
                //【1】ServerSocketChannelをオープンする
                ServerSocketChannel ssc = ServerSocketChannel.open()) {

            //【2】ソケットアドレス（ポート番号）をバインドする
            ssc.bind(new InetSocketAddress(55553)); // 55555→55553に変更

            while (true) { //【3】
                System.out.println("start accept");
                System.out.println("waiting...");
                SocketChannel socketChannel = ssc.accept(); //【4】接続を確立する（ブロッキング）
                readAndWrite(socketChannel); //【5】
                System.out.println("finish accept");
            }

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static void readAndWrite(SocketChannel socketChannel) {
        System.out.println("start process");

        //【1】新しいByteBufferを割り当てる（リクエスト用、レスポンス用）
        ByteBuffer requestBuffer = ByteBuffer.allocate(1000);
        ByteBuffer responseBuffer = ByteBuffer.allocate(1000);

        try {
            //【2】SocketChannelからByteBufferにデータを読み込む（ブロッキング）
            System.out.println("waiting...");
            socketChannel.read(requestBuffer);// ここで読み込みを待機する

            //【3】ByteBufferをフリップする
            requestBuffer.flip();

            //【4】リクエストをByteBufferから取り出し、何らかの業務処理を行う
            String request = StandardCharsets.UTF_8.decode(requestBuffer).toString();
            String response = "Hello! 私は" + request + "です";
            sleepAWhile(2000);

            //【5】レスポンスをByteBufferに追加する
            responseBuffer = StandardCharsets.UTF_8.encode(response);

            //【6】SocketChannelにByteBufferからデータを書き込む
            socketChannel.write(responseBuffer);
            System.out.println("response => " + response);

            // SocketChannelをクローズする
            socketChannel.close();

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }

        System.out.println("finish process");
    }
}