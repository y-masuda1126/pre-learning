package pro.kensait.java.advanced.lsn_6_1_5.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        //【1】新しいByteBufferを割り当てる（リクエスト用）
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        //【2】リクエストをByteBufferに追加する
        buffer = StandardCharsets.UTF_8.encode("Alice");

        try (
                //【3】DatagramChannelをオープンする
                DatagramChannel channel = DatagramChannel.open()) {

            //【4】DatagramChannelにByteBufferを書き込む
            System.out.println("send request");
            channel.send(buffer, new InetSocketAddress("localhost", 55555));

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}