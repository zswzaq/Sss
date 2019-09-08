package day15_0903.test1;

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
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpTools {

    /**
     * get请求
     * @param url 请求地址
     * @param map 请求参数 form表单
     * @return 
     * @throws Exception
     */
    public static String doGet(String url, Map<String, String> map) {
        try {
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
            String string = EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post请求
     * @param url 请求地址
     * @param map 请求参数对  ：form表单格式
     * @return
     * @throws Exception
     */
    public static String doPost(String url, Map<String, String> map) {
        try {
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
            String string = EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * doPost方法
     * @param url 请求url
     * @param requestData  json请求体
     * @return
     */
    public static String doPost(String url, String requestData) {
        try {
            HttpPost post = new HttpPost(url);
            // 设值请求头的必填项
            post.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
            // 创建一个json格式的请求体
            StringEntity entity = new StringEntity(requestData, ContentType.APPLICATION_JSON);
            // 设值请求体
            post.setEntity(entity);
            // 设值字符集
            entity.setContentEncoding("utf-8");
            // 创建一个发包客户端
            CloseableHttpClient createDefault = HttpClients.createDefault();
            // 发包,得到http响应
            CloseableHttpResponse response = createDefault.execute(post);
            // 3.获取响应体
            HttpEntity reEntity = response.getEntity();
            String string = EntityUtils.toString(reEntity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * doPost方法
     * @param apiCaseDetail 参数：用例详情对象
     * @return
     */
    public static String doPost(ApiCaseDetail apiCaseDetail) {
        try {
            HttpPost post = new HttpPost(apiCaseDetail.getApiInfo().getUrl());
            // 拿到所有的headers
            String headerStr = apiCaseDetail.getApiInfo().getHeaders();
            List<Headers> headers = JSONObject.parseArray(headerStr, Headers.class);
            // 设值请求头的必填项
            // post.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
            for (Headers header : headers) {
                post.setHeader(header.getName(), header.getValue());
            }
            // 创建一个json格式的请求体
            StringEntity entity = new StringEntity(apiCaseDetail.getRequestData(), ContentType.APPLICATION_JSON);
            // 设值请求体
            post.setEntity(entity);
            // 设值字符集
            entity.setContentEncoding("utf-8");
            // 创建一个发包客户端
            CloseableHttpClient createDefault = HttpClients.createDefault();
            // 发包,得到http响应
            CloseableHttpResponse response = createDefault.execute(post);
            // 3.获取响应体
            HttpEntity reEntity = response.getEntity();
            String string = EntityUtils.toString(reEntity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *  doGet方法
     * @param url 请求url
     * @param requestData 请求参数json格式
     * @return
     */
    public static String doGet(String url, String requestData) {
        try {
            // 容器
            List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
            // 把json对象转成map对象
            Map<String, Object> map = JSONObject.parseObject(requestData);
            Set<String> keySet = map.keySet();
            for (String key : keySet) {// 遍历一次，生成一对名值对
                String name = key;
                String value = (String) map.get(name);
                BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
                // 放名值对（键值对）
                parameters.add(nameValuePair);
            }
            // 格式化参数，变成 ：n=v&n=v&n=v...
            String params = URLEncodedUtils.format(parameters, "utf-8");
            // 创建一个http 的get请求
            HttpGet get = new HttpGet(url + "?" + params);
            get.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
            // 创建一个发包客户端
            CloseableHttpClient createDefault = HttpClients.createDefault();
            // 发包,得到http响应
            CloseableHttpResponse response = createDefault.execute(get);
            // 3.获取响应体
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *  dotGet方法
     * @param apiCaseDetail 参数：用例详情对象
     * @return
     */
    public static String doGet(ApiCaseDetail apiCaseDetail) {
        try {
            // 容器
            List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
            // 把json对象转成map对象
            Map<String, Object> map = JSONObject.parseObject(apiCaseDetail.getRequestData());
            Set<String> keySet = map.keySet();
            for (String key : keySet) {// 遍历一次，生成一对名值对
                String name = key;
                String value = (String) map.get(name);
                BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
                // 放名值对（键值对）
                parameters.add(nameValuePair);
            }
            // 格式化参数，变成 ：n=v&n=v&n=v...
            String params = URLEncodedUtils.format(parameters, "utf-8");
            // 创建一个http 的get请求
            HttpGet get = new HttpGet(apiCaseDetail.getApiInfo().getUrl() + "?" + params);
            // 拿到所有的headers
            String headerStr = apiCaseDetail.getApiInfo().getHeaders();
            List<Headers> headers = JSONObject.parseArray(headerStr, Headers.class);
            // 设值请求头的必填项
            for (Headers header : headers) {
                get.setHeader(header.getName(), header.getValue());
            }
            // get.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
            // 创建一个发包客户端
            CloseableHttpClient createDefault = HttpClients.createDefault();
            // 发包,得到http响应
            CloseableHttpResponse response = createDefault.execute(get);
            // 3.获取响应体
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity);// 工具包toString，将响应体转化为字符串
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // public static String doPost(ApiCaseDetail apiCaseDetail) {
    // return doPost(apiCaseDetail.getApiInfo().getUrl(),
    // apiCaseDetail.getRequestData());
    // }
    // public static String doGet(ApiCaseDetail apiCaseDetail) {
    // return doGet(apiCaseDetail.getApiInfo().getUrl(),
    // apiCaseDetail.getRequestData());
    // }
}
