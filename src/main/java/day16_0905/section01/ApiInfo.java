package day16_0905.section01;
import java.util.List;

/**
 * api的基本信息
 * 
 * @author happy
 *
 */
public class ApiInfo {

	// ApiId ApiName Url Type
	private String apiId;
	private String apiName;
	private String url;
	private String type;
	// private List<LemonHeader> headers;
	private String headers;

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "ApiInfo [apiId=" + apiId + ", apiName=" + apiName + ", url=" + url + ", type=" + type + ", headers="
				+ headers + "]";
	}

}
