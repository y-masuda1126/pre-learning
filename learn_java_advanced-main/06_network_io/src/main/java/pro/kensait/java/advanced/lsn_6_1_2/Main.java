package pro.kensait.java.advanced.lsn_6_1_2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        //【1】100バイトのバッファを持つByteBufferを生成する
        ByteBuffer buffer = ByteBuffer.allocate(100);

        //【2】数値（int型）をByteBufferに書き込む（4バイト）
        buffer.putInt(10);

        //【3】数値（long型）をByteBufferに書き込む（8バイト）
        buffer.putLong(1000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
        buffer.putLong(1000000000000000000L);
//        buffer.putLong(1000000000000000000L);
//        buffer.putLong(1000000000000000000L); // BufferOverflowException

        // 文字列からバイト列を生成し、ByteBufferに書き込む（14バイト）
        buffer.put("ABCDEFGHIJKLMN".getBytes(StandardCharsets.UTF_8));
        System.out.println("書き込み後残りバイト => " + buffer.remaining()); // 100-26=74

        //【4】ByteBufferをフリップする
        buffer.flip();
        System.out.println("flip後残りバイト => " + buffer.remaining()); // 26-0=26

        //【5】最初に書き込んだ数値（int型）を取り出して表示する（0バイト目から4バイト分）
        System.out.println("int型数値 => " + buffer.getInt());
        System.out.println("4バイト取得後の残りバイト => " + buffer.remaining()); // 26-4=22

        //【6】2度目に書き込んだ数値（long型）を取り出して表示する（4バイト目から8バイト分）
        System.out.println("long型数値 => " + buffer.getLong());
        System.out.println("8バイト取得後の残りバイト => " + buffer.remaining()); // 22-8=14

        // 次に書き込んだバイト列から文字列をデコードし、表示する（11バイト目から14バイト分）
        byte[] b = new byte[14];
        buffer.get(b);
        String str2 = new String(b, StandardCharsets.UTF_8);
        System.out.println("String型 => " + str2);
        System.out.println("14バイト取得後の残りバイト => " + buffer.remaining()); // 14-14=0

        // ByteBufferの読み込み位置を4バイト目に設定する
        buffer.position(4);

        // 2度目に書き込んだ数値（long型）を取り出して表示する（4バイト目から8バイト分）
        System.out.println("long型数値 => " + buffer.getLong());
        System.out.println("8バイト取得後残りバイト => " + buffer.remaining()); // 26-(4+8)=14
    }
}