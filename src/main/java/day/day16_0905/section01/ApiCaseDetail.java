package day.day16_0905.section01;
/**
 * 接口测试用例的详细信息
 * 
 * @author happy
 *
 */
public class ApiCaseDetail {
	// CaseId ApiId RequestData
	private String caseId;
	private String apiId;
	private String requestData;
	//断言的关键信息
	private String expectedRespKeyInfo;
	// 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性
	private ApiInfo apiInfo;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public ApiInfo getApiInfo() {
		return apiInfo;
	}

	public void setApiInfo(ApiInfo apiInfo) {
		this.apiInfo = apiInfo;
	}

	public String getExpectedRespKeyInfo() {
		return expectedRespKeyInfo;
	}

	public void setExpectedRespKeyInfo(String expectedRespKeyInfo) {
		this.expectedRespKeyInfo = expectedRespKeyInfo;
	}

	@Override
	public String toString() {
		return "ApiCaseDetail [caseId=" + caseId + ", apiId=" + apiId + ", requestData=" + requestData
				+ ", expectedRespKeyInfo=" + expectedRespKeyInfo + ", apiInfo=" + apiInfo + "]";
	}

}
