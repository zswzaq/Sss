package day.day12_0827.test;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class doGet {

    public static void main(String[] args) throws Exception {

        // 创建一个http 的get请求
        HttpGet get = new HttpGet("http://test.lemonban.com/ningmengban/app/login/login.html");
        // 准备一个发包客户端
        CloseableHttpClient createDefault = HttpClients.createDefault();
        // 发包 ，接收响应
        CloseableHttpResponse response = createDefault.execute(get);
        System.out.println(response.getStatusLine().getProtocolVersion());// 1.获取状态行的版本
        System.out.println(response.getStatusLine().getStatusCode());// 获取状态行的状态码
        System.out.println(response.getStatusLine().getReasonPhrase());// 获取状态行的原因短语
        // 2. 获取所有的请求头部信息
        Header[] allHeaders = response.getAllHeaders();
        for (Header header : allHeaders) {
            String headerName = header.getName();// 获取header头的name
            String headerValue = header.getValue();// 获取header头的值
            System.out.println(headerName + ":" + headerValue);
        }
        System.out.println();
        // 3.获取响应体
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
        System.out.println(string);
    }

}
