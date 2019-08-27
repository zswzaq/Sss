package day12_0827.section02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostTester4 {

	public static void main(String[] args) throws ClientProtocolException, IOException {
	/*	//准备url
		String url = "http://test.lemonban.com/ningmengban/mvc/user/login.json";
		//准备参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("password", "123456");
		map.put("username", "1355555555");
		
		String result = test_case_1(url, map);
		System.out.println(result);*/
		
		
		String url = "http://test.lemonban.com/ningmengban/mvc/user/register.json";
		//参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("password", "123456");
		paramMap.put("username", "1355555555");
		paramMap.put("code", "8888");
		
		//发起请求
		String result = test_case_1(url, paramMap);
		System.out.println(result);
		
	}
	/**
	 * 1：参数的值是变化的
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */

	//对于不同的接口：参数是不一样的、url也是不一样的
	//1：url
	//2：参数列表:什么样的数据类型可以保存任意一个接口的所有参数-->Map
	
	private static String test_case_1(String url, Map<String,String> map) throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost(url);
		//参数容器
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		//参数都在map中
		Set<String> keySet = map.keySet();
		for (String key : keySet) {//每遍历一次都要生成一个名值对
			String name = key;
			String value = map.get(key);
			//每遍历一次都要生成一个名值对
			BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
			parameters.add(nameValuePair);
		}
		
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		//设值请求体
		post.setEntity(formEntity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		return entityStr;
	}

}
