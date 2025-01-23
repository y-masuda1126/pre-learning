package pro.kensait.java.advanced.lsn_6_1_4.server;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Main {
    private static Selector selector;

    public static void main(String[] args) {
        try (
                //【1】ServerSocketChannelをオープンする
                ServerSocketChannel ssc = ServerSocketChannel.open()) {

            //【2】ソケットアドレス（ポート番号）をバインドする
            ssc.bind(new InetSocketAddress(55554)); // 55555→55554に変更

            //【3】ノンブロッキングモードに設定する
            ssc.configureBlocking(false);

            //【4】セレクタをオープンする
            selector = Selector.open();

            //【5】ServerSocketChannelをセレクタに登録する
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            int count;
            while (0 < (count = selector.select())) { //【6】ブロッキング
                System.out.println("select count => " + count);

                //【7】準備完了したキーの集合を取得し、while文でループ処理する
                Iterator<SelectionKey> keyIterator = selector.selectedKeys()
                        .iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isAcceptable()) {
                        //【8】接続処理の準備が完了していた場合
                        accept((ServerSocketChannel) key.channel());
                    } else if (key.isReadable()) {
                        //【9】読み込み処理の準備が完了していた場合
                        readAndWrite((SocketChannel) key.channel());
                    }
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    // 接続処理
    private static void accept(ServerSocketChannel ssc) {
        System.out.println("start accept");
        try {
            //【1】接続を受け付け、SocketChannelを取得する
            SocketChannel socketChannel = ssc.accept();

            //【2】ノンブロッキングモードに設定する
            socketChannel.configureBlocking(false);

            //【3】SocketChannelをセレクタに登録する
            socketChannel.register(selector, SelectionKey.OP_READ);

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        System.out.println("finish accept");
    }

    // 読み込みと書き込み処理
    private static void readAndWrite(SocketChannel socketChannel) {
        System.out.println("start read and write");

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

            // SocketChannelをクローズする
            socketChannel.close();

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        System.out.println("finish read and write");
    }
}