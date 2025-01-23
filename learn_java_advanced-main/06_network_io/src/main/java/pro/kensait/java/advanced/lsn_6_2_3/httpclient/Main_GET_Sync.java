package pro.kensait.java.advanced.lsn_6_2_3.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main_GET_Sync {
    public static void main(String[] args) throws Exception {
        // HttpClientオブジェクトを生成する
        HttpClient client = HttpClient.newBuilder() //【1】
                .version(HttpClient.Version.HTTP_2) //【2】
                .build(); //【3】

        // HttpRequestオブジェクトを生成する
        HttpRequest request = HttpRequest.newBuilder() //【4】
                .uri(URI.create("http://localhost:8080?name=Alice")) //【5】
                .header("User-Agent", "Java SE HttpClient") //【6】
                .GET()
                .build(); //【7】

        // HttpRequestを送信し、HttpResponseを受け取る
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // HttpResponseからステータスを取得する
        int status = response.statusCode(); //【8】ステータス
        System.out.println("[ STATUS ]");
        System.out.println(status);

        // HttpResponseからヘッダを取得する
        HttpHeaders resHeaders = response.headers(); //【9】HTTPヘッダ
        System.out.println("[ HEADERS ]");
        for (Map.Entry<String, List<String>> entry : resHeaders.map().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(0));
        }

        // HttpResponseからボディを取り出す
        String resBody = response.body(); //【10】ボディ
        System.out.println("[ BODY ]");
        System.out.println(resBody);
    }
}