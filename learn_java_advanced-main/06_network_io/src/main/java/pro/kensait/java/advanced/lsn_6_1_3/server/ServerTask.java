package pro.kensait.java.advanced.lsn_6_1_3.server;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ServerTask implements Runnable {
    private SocketChannel socketChannel;
    
    public ServerTask(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        System.out.println("start thread");

        // 新しいByteBufferを割り当てる（リクエスト用、レスポンス用）
        ByteBuffer requestBuffer = ByteBuffer.allocate(1000);
        ByteBuffer responseBuffer = ByteBuffer.allocate(1000);
 
        try {
            // SocketChannelからByteBufferにデータを読み込む
            socketChannel.read(requestBuffer);

            // ByteBufferをフリップする
            requestBuffer.flip();

            // リクエストをByteBufferからデコードし、何らかの業務処理を行う
            String request = StandardCharsets.UTF_8.decode(requestBuffer).toString();
            String response = "Hello! 私は" + request + "です";
            sleepAWhile(2000);

            // レスポンスをByteBufferに追加する
            responseBuffer = StandardCharsets.UTF_8.encode(response);

            // SocketChannelにByteBufferからデータを書き込む
            socketChannel.write(responseBuffer);
            System.out.println("response => " + response);

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }

        System.out.println("finish thread");
    }
}
