package day.day16_0905.test;

/**
 * 接口测试用例的详细信息
 * 
 * @author Administrator
 */
public class ApiCaseDetail {
    private String caseId;
    private String apiId;
    private String requestData;
    // 有一个ApiInfo属性
    private ApiInfo apiInfo;
    // 断言预期结果
    private String expectedResultInfo;

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

    public String getExpectedResultInfo() {
        return expectedResultInfo;
    }

    public void setExpectedResultInfo(String expectedResultInfo) {
        this.expectedResultInfo = expectedResultInfo;
    }

    @Override
    public String toString() {
        return "ApiCaseDetail [caseId=" + caseId + ", apiId=" + apiId + ", requestData=" + requestData + ", apiInfo="
                + apiInfo + ", expectedResultInfo=" + expectedResultInfo + "]";
    }

}
