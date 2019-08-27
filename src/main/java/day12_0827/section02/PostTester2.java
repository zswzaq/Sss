package day12_0827.section02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostTester2 {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		test_case_1();
		test_case_2();
		test_case_3();
		test_case_4();
	}
	/**
	 * 1：参数的值是变化的
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	private static void test_case_1() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "13555555555"));
		parameters.add(new BasicNameValuePair("password", "fcea920f7412b5da7be0cf42b8c93759"));
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		post.setEntity(formEntity);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		System.out.println(entityStr);
	}
	
	private static void test_case_2() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "135555"));
		parameters.add(new BasicNameValuePair("password", "fcea920f7412b5da7be0cf42b8c93759"));
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		post.setEntity(formEntity);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		System.out.println(entityStr);
	}
	
	private static void test_case_3() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "lemon"));
		parameters.add(new BasicNameValuePair("password", "fcea920f7412b5da7be0cf42b8c93759"));
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		post.setEntity(formEntity);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		System.out.println(entityStr);
	}
	
	private static void test_case_4() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "1388888888"));
		parameters.add(new BasicNameValuePair("password", "123456"));
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		post.setEntity(formEntity);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		System.out.println(entityStr);
	}

}
