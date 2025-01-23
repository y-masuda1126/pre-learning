package pro.kensait.java.advanced.lsn_6_1_4.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // 新しいByteBufferを割り当てる（リクエスト用、レスポンス用）
        ByteBuffer requestBuffer = ByteBuffer.allocate(1000);
        ByteBuffer responseBuffer = ByteBuffer.allocate(1000);

        // リクエストをByteBufferに追加する
        requestBuffer = StandardCharsets.UTF_8.encode("Alice");

        try (
                // SocketChannelをオープンする
                SocketChannel socketChannel = SocketChannel.open(
                        new InetSocketAddress("localhost", 55554))) { // 55555→55554に変更

            // SocketChannelにByteBufferを書き込む
            System.out.println("sending request...");
            socketChannel.write(requestBuffer);

            // SocketChannelからByteBufferに読み込む
            System.out.println("receiving response...");
            socketChannel.read(responseBuffer);

            // ByteBufferをフリップする
            responseBuffer.flip();

            // レスポンスをByteBufferから取り出す
            String response = StandardCharsets.UTF_8.decode(responseBuffer).toString();
            System.out.println("response => " + response);

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}