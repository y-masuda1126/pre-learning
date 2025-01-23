package pro.kensait.java.advanced.lsn_6_2_3.httpclient;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main_GET_Sync_Encoded {
    public static void main(String[] args) throws Exception {
        // HttpClientオブジェクトを生成する
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // HttpRequestオブジェクトを生成する
        String encodedName = URLEncoder.encode("さいとう", "UTF-8");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080?name=" + encodedName))
                .header("User-Agent", "Java SE HttpClient")
                .build();

        // HttpRequestを送信し、HttpResponseを受け取る
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // HttpResponseからステータスを取得する
        int status = response.statusCode();
        System.out.println("[ STATUS ]");
        System.out.println(status);

        // HttpResponseからヘッダを取得する
        HttpHeaders resHeaders = response.headers();
        System.out.println("[ HEADERS ]");
        for (Map.Entry<String, List<String>> entry : resHeaders.map().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(0));
        }

        // HttpResponseからボディを取り出す
        String resBody = response.body();
        System.out.println("[ BODY ]");
        System.out.println(resBody);
    }
}