package pro.kensait.java.advanced.lsn_6_2_3.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("========================================");

        // HTTPリクエストの各種情報を取得する
        String method = exchange.getRequestMethod();
        String requestURI = exchange.getRequestURI().toString();
        String query = exchange.getRequestURI().getQuery();
        String protocol = exchange.getProtocol();
        Headers reqHeaders = exchange.getRequestHeaders();

        // リクエストボディを取得する
        InputStream is = exchange.getRequestBody();
        byte[] reqData = is.readAllBytes();
        is.close();

        // 開始行を表示する
        String startLine = method + " " + requestURI + " " + protocol;
        System.out.println(startLine);

        // リクエストヘッダを表示する
        for (String name : reqHeaders.keySet()) {
            System.out.println(name + ": " + reqHeaders.getFirst(name));
        }

        // リクエストボディを表示する
        String reqBody = null;
        if (reqData.length != 0) {
            System.out.println();
            reqBody = new String(reqData, StandardCharsets.UTF_8);
            System.out.println(reqBody);
        }

        // パラメータを取得する
        Map<String, String> paramMap = null;
        if (query != null && ! query.equals("")) {
            paramMap = queryToMap(query);
        } else {
            paramMap = queryToMap(reqBody);
        }

        // レスポンスボディを生成する
        String personName = paramMap.get("name");
        String resBody = null;
        if (personName == null || personName.equals("")) {
            resBody = "Hello!";
        } else {
            resBody = "Hello! 私は" + personName + "です";
        }

        // Content-Length以外のレスポンスヘッダを設定する
        Headers resHeaders = exchange.getResponseHeaders();
        resHeaders.set("Content-Type", "application/text");

        // レスポンスヘッダを送信する
        int statusCode = 200;
        long contentLength = resBody.getBytes(StandardCharsets.UTF_8).length;
        exchange.sendResponseHeaders(statusCode, contentLength);

        // レスポンスボディを送信する
        OutputStream os = exchange.getResponseBody();
        os.write(resBody.getBytes());
        os.close();
    }

    private Map<String, String> queryToMap(String query) {
        Map<String, String> map = new HashMap<>();
        if (query == null) return map;
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                map.put(entry[0], entry[1]);
            }else{
                map.put(entry[0], "");
            }
        }
        return map;
    }
}