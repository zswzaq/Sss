package day.day17_0910.test;

/**
 * 接口测试用例的详细信息
 * 
 * @author Administrator
 */
public class ApiCaseDetail extends Excel{
    private String caseId;
    private String apiId;
    private String requestData;
    // 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性
    private ApiInfo apiInfo;
    // 断言预期结果
    private String expectedResultInfo;
    // 写回excel的实际数据
    private String actualRespData;
    
    
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

    public String getActualRespData() {
        return actualRespData;
    }

    public void setActualRespData(String actualRespData) {
        this.actualRespData = actualRespData;
    }

    @Override
    public String toString() {
        return "ApiCaseDetail [caseId=" + caseId + ", apiId=" + apiId + ", requestData=" + requestData + ", apiInfo="
                + apiInfo + ", expectedResultInfo=" + expectedResultInfo + ", actualRespData=" + actualRespData
                + ", getRowNo()=" + getRowNo() + "]";
    }

    

}
