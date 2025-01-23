package pro.kensait.java.advanced.lsn_6_1_5.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class ClientTask implements Runnable {
    private String request;

    public ClientTask(String request) {
        this.request = request;
    }

    @Override
    public void run() {
        // 新しいByteBufferを割り当てる（リクエスト用）
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        // リクエストをByteBufferに追加する
        buffer = StandardCharsets.UTF_8.encode(request);

        try (
                // DatagramChannelをオープンする
                DatagramChannel channel = DatagramChannel.open()) {

            // DatagramChannelにByteBufferを書き込む
            System.out.println("send request => " + request);
            channel.send(buffer, new InetSocketAddress("localhost", 55555));

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}