package pro.kensait.java.advanced.lsn_6_1_5.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        //【1】新しいByteBufferを割り当てる（リクエスト用）
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        try (
                //【2】DatagramChannelをオープンする
                DatagramChannel channel = DatagramChannel.open()) {

            //【3】ソケットアドレス（ポート番号）をバインドする
            channel.bind(new InetSocketAddress(55555));

            while (true) { //【4】
                //【5】受信を待機する
                channel.receive(buffer);

                //【6】ByteBufferをフリップする
                buffer.flip();

                //【7】リクエストをByteBufferから取り出す
                String request = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("Hello! 私は" + request + "です");
            }

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}