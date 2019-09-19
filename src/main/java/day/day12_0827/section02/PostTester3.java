package day.day12_0827.section02;

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

public class PostTester3 {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		test_case_1("13888888888","123456");
		test_case_1("lemon","123456");
		test_case_1("13888","123456");
	}
	/**
	 * 1：参数的值是变化的
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	//对于不同的接口：参数是不一样的、url也是不一样的
	//1：url
	//2：参数列表
	private static void test_case_1(String userName,String password) throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost("http://test.lemonban.com/ningmengban/mvc/user/login.json");

		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", userName));
		parameters.add(new BasicNameValuePair("password", password));
		
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
