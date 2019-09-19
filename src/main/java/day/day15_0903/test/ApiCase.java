package day.day15_0903.test;

public class ApiCase {
	// CaseId Url RequestData
	private String caseId;
	private String url;
	private String requestData;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	@Override
	public String toString() {
		return "ApiCase [caseId=" + caseId + ", url=" + url + ", requestData=" + requestData + "]";
	}

}
