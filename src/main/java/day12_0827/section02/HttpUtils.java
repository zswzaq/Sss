package day12_0827.section02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	/**
	 * post请求
	 * 
	 * @param url
	 *            请求url
	 * @param map
	 *            请求的数据
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String post(String url, Map<String, String> map)
			throws UnsupportedEncodingException, IOException, ClientProtocolException {
		HttpPost post = new HttpPost(url);
		// 参数容器
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		// 参数都在map中
		Set<String> keySet = map.keySet();
		for (String key : keySet) {// 每遍历一次都要生成一个名值对
			String name = key;
			String value = map.get(key);
			// 每遍历一次都要生成一个名值对
			BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
			parameters.add(nameValuePair);
		}

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "utf-8");
		// 设值请求体
		post.setEntity(formEntity);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(post);
		// 3：获取响应体
		HttpEntity respEntity = response.getEntity();
		String entityStr = EntityUtils.toString(respEntity);
		return entityStr;
	}

	public static String get(String url, Map<String, String> map) throws Exception {
		// get请求的参数要拼接
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();

		Set<String> keySet = map.keySet();
		for (String key : keySet) {// 每遍历一次都要生成一个名值对
			String name = key;
			String value = map.get(key);
			// 每遍历一次都要生成一个名值对
			BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
			parameters.add(nameValuePair);
		}

		String params = URLEncodedUtils.format(parameters, "utf-8");

		// 准备好一个get请求
		HttpGet get = new HttpGet(url + "?" + params);

		// 准备一个http发包客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 发包,得到http响应
		CloseableHttpResponse response = httpClient.execute(get);

		// 3：获取响应体
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity);
	}
}
