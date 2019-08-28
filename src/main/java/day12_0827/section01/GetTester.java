package day12_0827.section01;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetTester {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        // 发一个get请求的步骤
        // 准备好一个get请求
        HttpGet get = new HttpGet("http://test.lemonban.com/ningmengban/app/login/login.html");
        // 准备一个http发包客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 发包,得到http响应
        CloseableHttpResponse response = httpClient.execute(get);
        // 1：获取状态行：
        StatusLine statusLine = response.getStatusLine();
        System.out.print(statusLine.getProtocolVersion() + " ");// 协议版本
        System.out.print(statusLine.getStatusCode() + " ");// 状态码
        System.out.println(statusLine.getReasonPhrase());// 原因短语
        // 2:获取响应头
        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            String headerName = header.getName();
            String headerValue = header.getValue();
            System.out.println(headerName + ":" + headerValue);
        }
        System.out.println();
        // 3：获取响应体
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        System.out.println(entityStr);
    }

}
