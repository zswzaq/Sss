package day.day16_0905.section01;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
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
	public static String post(String url, Map<String, String> map) {
		String entityStr = null;
		try {
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
			entityStr = EntityUtils.toString(respEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityStr;
	}

	/**
	 * post方法
	 * 
	 * @param url
	 *            请求url
	 * @param requestData
	 *            请求体（json字符串）
	 * @return
	 */
	public static String post(ApiCaseDetail apiCaseDetail) {
		String entityStr = null;
		try {
			HttpPost post = new HttpPost(apiCaseDetail.getApiInfo().getUrl());
			// 拿到所有的headers
			String headersStr = apiCaseDetail.getApiInfo().getHeaders();
			List<LemonHeader> headers = JSONObject.parseArray(headersStr, LemonHeader.class);
			// 设置必须的请求头
			post.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
			for (LemonHeader lemonHeader : headers) {
				post.setHeader(lemonHeader.getName(), lemonHeader.getValue());
			}
			// 创建一个请求体
			StringEntity entity = new StringEntity(apiCaseDetail.getRequestData(), ContentType.APPLICATION_JSON);
			// 设置字符集
			entity.setContentEncoding("utf-8");
			// 设值请求体
			post.setEntity(entity);
			// 创建发包客户端
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// 得到响应
			CloseableHttpResponse response = httpClient.execute(post);
			// 获取响应体
			HttpEntity respEntity = response.getEntity();
			entityStr = EntityUtils.toString(respEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityStr;
	}

	/**
	 * post方法
	 * 
	 * @param apiCaseDetail
	 *            接口测试用例详细信息
	 * @return
	 */
	// public static String post(ApiCaseDetail apiCaseDetail) {
	// return post(apiCaseDetail);
	// }

	/**
	 * get
	 * 
	 * @param url
	 *            请求url
	 * @param map
	 *            参数
	 * @return
	 */
	public static String get(String url, Map<String, String> map) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get
	 * 
	 * @param url
	 *            请求url
	 * @param map
	 *            参数
	 * @return
	 */
	public static String get(ApiCaseDetail apiCaseDetail) {
		try {
			// get请求的参数要拼接
			List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
			// 把json对象转成map对象
			Map<String, Object> map = JSONObject.parseObject(apiCaseDetail.getRequestData());
			Set<String> keySet = map.keySet();
			for (String key : keySet) {// 每遍历一次都要生成一个名值对
				String name = key;
				String value = map.get(key).toString();
				// 每遍历一次都要生成一个名值对
				BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
				parameters.add(nameValuePair);
			}
			String params = URLEncodedUtils.format(parameters, "utf-8");
			// 准备好一个get请求
			HttpGet get = new HttpGet(apiCaseDetail.getApiInfo().getUrl() + "?" + params);// http://domian/path?xx=yy&aa=bb&cc=dd
			// 设置必须的请求头
			// get.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
			String headersStr = apiCaseDetail.getApiInfo().getHeaders();
			List<LemonHeader> headers = JSONObject.parseArray(headersStr, LemonHeader.class);
			for (LemonHeader lemonHeader : headers) {
				get.setHeader(lemonHeader.getName(), lemonHeader.getValue());
			}
			// 准备一个http发包客户端
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// 发包,得到http响应
			CloseableHttpResponse response = httpClient.execute(get);

			// 3：获取响应体
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String delete(ApiCaseDetail apiCaseDetail) {
		// TODO 编写delete方法的具体的逻辑
		return null;
	}

	private static String patch(ApiCaseDetail apiCaseDetail) {
		// FIXME 编写patch方法的具体的逻辑
		return null;
	}
	public static String delete(String url, Map<String, String> map) throws Exception {
		// HttpDelete
		return null;
	}

	public static String put(String url, Map<String, String> map) throws Exception {
		// HttpPut
		return null;
	}

	public static String patch(String url, Map<String, String> map) throws Exception {
		// HttpPatch
		return null;
	}

	/**
	 * 执行测试用例
	 * 
	 * @param apiCaseDetail
	 *            测试用例详细信息对象
	 *            GET/POST字符串硬编码：常量、枚举
	 * @return
	 */
	public static String excute(ApiCaseDetail apiCaseDetail) {
		//请求方法
		String type = apiCaseDetail.getApiInfo().getType();
		//请求的分发
		String result = null;
		if ("GET".equalsIgnoreCase(type)) {
			result = HttpUtils.get(apiCaseDetail);
		} else if ("POST".equalsIgnoreCase(type)) {
			result = HttpUtils.post(apiCaseDetail);
		} else if ("PATCH".equalsIgnoreCase(type)) {
			result = HttpUtils.patch(apiCaseDetail);
		}else if("DELETE".equalsIgnoreCase(type)){
			result = HttpUtils.delete(apiCaseDetail);
		}
		return result;
	}


}
