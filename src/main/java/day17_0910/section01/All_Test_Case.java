package day17_0910.section01;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class All_Test_Case {
	
	@DataProvider
	public Object[][] getData() {
		return ApiUtils.getData();
	}

	
	@Test(dataProvider = "getData")
	public void test_case(ApiCaseDetail apiCaseDetail) throws Exception{
		String actualResult = HttpUtils.excute(apiCaseDetail);
		//写回到Excel
		//往第1行，第4列写入aaa
		//往第2行，第4列写入bbb
		//往第3行，第4列写入ccc
		//往第4行，第4列写入ddd
		
		//往第1行，第6列写入通过
		//往第2行，第6列写入不通过
		
		//行号getRowNo   列号：4，写回的内容是：actualResult
		//搜集要写的数据
		CellData cellData = new CellData(apiCaseDetail.getRowNo(), 5, actualResult);
		ApiUtils.setCellData(cellData);
		
		//excel的源路径，目标路径、表单的索引、行的索引、列的索引
//		ExcelUtils.writeExcel("/case17/test_case_01.xlsx","d://"+apiCaseDetail.getCaseId()+".xlsx",0,cellData);
		
		AssertUtils.assertRespKeyInfo(apiCaseDetail,actualResult);
		System.out.println(actualResult);
	}
	
	//执行所有的测试用例完之后，写一遍！！
	@AfterSuite
	public void afterSuite(){
		ExcelUtils.batchWrite("/case/test_case_all.xlsx","d://api.xlsx",0);
		
	}
	
}
