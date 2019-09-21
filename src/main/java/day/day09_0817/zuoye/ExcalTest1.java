package day.day09_0817.zuoye;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcalTest1 {
    public static void main(String[] args) throws Exception {

        // 通过流创建：：类.class.getResourceAsStream()
        InputStream file = ExcalTest1.class.getResourceAsStream("/Person.xlsx");
        // 工作薄，，通过工作薄的工厂创建，需要引用一个文件，通过上步骤的流创建
        Workbook workbook = WorkbookFactory.create(file);
        // 获取指定的表单：传名称，索引等都可以
        Sheet sheetAt = workbook.getSheetAt(0);
        // 获得一行的数据
        Row rowFirst = sheetAt.getRow(0);
        // 获得第一行(索引0)的第一列，需要设置缺省单元格策略 ，空白可作为空白(空字符串)，而不是null(会出空指针异常)
        Cell cellFirst = rowFirst.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
        // 获得该列的值
        String stringCellValue = cellFirst.getStringCellValue();
        // System.out.println(stringCellValue);

        /** -----获得第一行的数据（属性/变量）--开始----------------------------- */
        Row row = sheetAt.getRow(0);
        // 确定第一行多少列(获得最大列的编号)
        short lastCellNum = row.getLastCellNum();
        // System.out.println(lastCellNum);
        // 循环遍历获得索引的列
        for (int i = 0; i < lastCellNum; i++) {
            // 获得当前列，需要设置缺省单元格策略 ，空白可作为空白(空字符串)，而不是null(会出空指针异常)
            Cell cellCurrent = row.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String stringValue = cellCurrent.getStringCellValue();
            System.out.println(stringValue);
        }
        /** -----获得第一行的数据（属性/变量）--结束----------------------------- */

    }

}
