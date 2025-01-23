package pro.kensait.java.advanced.lsn_6_2_4.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main_GET_Async_3 {
    public static void main(String[] args) throws Exception {
        // 手順1：HttpClientオブジェクトを生成する
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // 手順2：HttpRequestオブジェクトを生成する
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080?name=Alice"))
                .header("User-Agent", "Java SE HttpClient")
                .build();

        // 手順3＋4：HttpRequestを送信し、HTTPサーバーを非同期で呼び出す
        // → CompletableFutureからHttpResponseを取得し、メソッドチェーンによって後処理を行う
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response
                        -> "### " + response.body() + " ###") //【1】Function型を受け取る
                .thenAccept(System.out::println); //【2】Consumer型を受け取る

        System.out.println("send request, receiving response...");

        Thread.sleep(30000);
    }
}