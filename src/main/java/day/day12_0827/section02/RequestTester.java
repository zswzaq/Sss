package day.day12_0827.section02;

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

public class RequestTester {

	public static void main(String[] args) throws Exception {
		// test.lemonban.com/futureloan/mvc/api/member/register?mobilephone=xxx&pwd=xxx
		String url = "http://test.lemonban.com/futureloan/mvc/api/member/register";
		// 参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mobilephone", "13888888888");
		paramMap.put("pwd", "123456");

		// 发起请求
//		String result = HttpUtils.get(url, paramMap);
		String result = HttpUtils.post(url, paramMap);
		System.out.println(result);
	}
}
