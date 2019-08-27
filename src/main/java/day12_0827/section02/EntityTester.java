package day12_0827.section02;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class EntityTester {

	public static void main(String[] args) {
		List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
		parameters.add(new BasicNameValuePair("username", "13555555555"));
		parameters.add(new BasicNameValuePair("password", "fcea920f7412b5da7be0cf42b8c93759"));
		parameters.add(new BasicNameValuePair("aaa", "aaa"));
		parameters.add(new BasicNameValuePair("bbb", "bbb"));
		parameters.add(new BasicNameValuePair("ccc", "ccc"));
		
		String str = URLEncodedUtils.format(parameters, "utf-8");
		System.out.println(str);
	}

}
