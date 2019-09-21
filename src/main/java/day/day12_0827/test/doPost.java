package day.day12_0827.test;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class doPost {

    public static void main(String[] args) throws Exception {
        // 准备一个post请求
        HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");
        // 配置参数
        HttpEntity stringEntity = new StringEntity("username=13666666666&password=fcea920f7412b5da7be0cf42b8c93759",
                ContentType.APPLICATION_FORM_URLENCODED);
        post.setEntity(stringEntity);// 设置参数到请求体中
        // 创建一个发包客户端
        CloseableHttpClient createDefault = HttpClients.createDefault();
        // 发包,得到http响应
        CloseableHttpResponse response = createDefault.execute(post);
        // 1.获取状态行
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
