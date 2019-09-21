package day.day12_0827.section02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostTester {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// 发一个post请求的步骤

		// 准备好一个post请求
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");
		// 参数的设置:post请求大部分参数都是设置在请求体中
		
		//名值对
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "13555555555"));
		parameters.add(new BasicNameValuePair("password", "fcea920f7412b5da7be0cf42b8c93759"));
		
		//构造：UrlEncodedFormEntity(List<? extends NameValuePair> parameters, String charset)
		//List<? extends NameValuePair> parameters：参数列表
		//? extends NameValuePair:list的元素类型是继承自NameValuePair的子类
		//charset:字符集
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		
		post.setEntity(formEntity);

		// 准备一个http发包客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 发包,得到http响应
		CloseableHttpResponse response = httpClient.execute(post);

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
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		System.out.println(entityStr);

	}

}
