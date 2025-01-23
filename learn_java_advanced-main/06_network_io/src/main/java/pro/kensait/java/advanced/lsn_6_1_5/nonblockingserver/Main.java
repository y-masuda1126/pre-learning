package pro.kensait.java.advanced.lsn_6_1_5.nonblockingserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Main {
    private static Selector selector;

    public static void main(String[] args) {
        try (
                // DatagramChannelをオープンする
                DatagramChannel channel = DatagramChannel.open()) {

            // ソケットアドレス（ポート番号）をバインドする
            channel.bind(new InetSocketAddress(55552)); // 55555→55552に変更

            // ノンブロッキングモードに設定する
            channel.configureBlocking(false);

            // セレクタをオープンする
            selector = Selector.open();

            // セレクタに登録する
            channel.register(selector, SelectionKey.OP_READ);

            int count;
            while (0 < (count = selector.select())) { // ここで受信を待機
                System.out.println("selector's count => " + count);

                // 準備完了したキーの集合を取得し、while文でループ処理する
                Iterator<SelectionKey> keyIterator = selector.selectedKeys()
                        .iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();
                    if (key.isReadable()) {
                        // 読み込み処理の準備が完了していた場合
                        read((DatagramChannel) key.channel());
                    }
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    // 読み込み処理
    private static void read(DatagramChannel channel) {
        System.out.println("start read");

        // 新しいByteBufferを割り当てる（リクエスト用）
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        try {
            // DatagramChannelからByteBufferにデータを読み込む
            channel.receive(buffer);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        // ByteBufferをフリップする
        buffer.flip();

        // リクエストをByteBufferから取り出す
        String request = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println("Hello! 私は" + request + "です");

        System.out.println("finish read");
    }
}