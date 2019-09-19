package day.day12_0827.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpTools {

    /**
     * get请求
     * @param url 请求地址
     * @param map 请求参数
     * @return
     * @throws Exception
     */
    public static String doGet(String url, Map<String, String> map) throws Exception {

        // 容器
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        Set<String> keySet = map.keySet();
        for (String string : keySet) {// 遍历一次，生成一对名值对
            String name = string;
            String value = map.get(name);
            BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
            // 放名值对（键值对）
            parameters.add(nameValuePair);
        }
        // 格式化参数，变成 ：n=v&n=v&n=v...
        String params = URLEncodedUtils.format(parameters, "utf-8");
        // 创建一个http 的get请求
        HttpGet get = new HttpGet(url + "?" + params);
        // 创建一个发包客户端
        CloseableHttpClient createDefault = HttpClients.createDefault();
        // 发包,得到http响应
        CloseableHttpResponse response = createDefault.execute(get);
        // 3.获取响应体
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
    }

    /**
     * post请求
     * @param url 请求地址
     * @param map 请求参数对
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, String> map) throws Exception {
        HttpPost post = new HttpPost(url);

        // 容器
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        Set<String> keySet = map.keySet();
        for (String string : keySet) {// 遍历一次，生成一对名值对
            String name = string;
            String value = map.get(name);
            BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
            // 放名值对（键值对）
            parameters.add(nameValuePair);
        }
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");// 设置字符集（可以不设置）
        post.setEntity(formEntity);
        // 创建一个发包客户端
        CloseableHttpClient createDefault = HttpClients.createDefault();
        // 发包,得到http响应
        CloseableHttpResponse response = createDefault.execute(post);
        // 3.获取响应体
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
    }

}
