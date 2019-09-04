package day15_0903.section01;

/**
 * 接口测试用例的详细信息
 * @author happy
 *
 */
public class ApiCaseDetail {
	// CaseId ApiId RequestData
	private String caseId;
	private String apiId;
	private String requestData;

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

	@Override
	public String toString() {
		return "ApiCaseDetail [caseId=" + caseId + ", apiId=" + apiId + ", requestData=" + requestData + "]";
	}

}
