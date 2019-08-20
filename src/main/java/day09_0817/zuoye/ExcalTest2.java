package day09_0817.zuoye;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcalTest2 {
    public static void main(String[] args) throws Exception {
        List<Person> readExcal = readExcal("/Person.xlsx",0);
        for (Person person : readExcal) {
            System.out.println(person);
        }
    }

    private static List<Person> readExcal(String url,int sheetNum) throws IOException, InvalidFormatException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        // 创建一个List 接收person
        List<Person> pList = new ArrayList<Person>();
        // 2.通过流创建：：类.class.getResourceAsStream()
        InputStream file = ExcalTest2.class.getResourceAsStream(url);
        // 1.工作薄，，通过工作薄的工厂创建，需要引用一个文件，通过上步骤的流创建
        Workbook workbook = WorkbookFactory.create(file);
        // 获取指定的表单：传名称，索引等都可以
        Sheet sheetAt = workbook.getSheetAt(0);

        /** -----获得第一行的数据（属性/变量）--开始----------------------------- */
        Row row = sheetAt.getRow(sheetNum);
        // 确定第一行多少列(获得最大列的编号)
        short lastCellNum = row.getLastCellNum();
        // 创建一个容器，存放所有的属性名字（长度就等于最大列，不用加1）
        String[] bialiangs = new String[lastCellNum];
        // 循环遍历获得索引的列（0到最大列-1）
        for (int i = 0; i < lastCellNum; i++) {
            // 获得当前列，需要设置缺省单元格策略 ，空白可作为空白(空字符串)，而不是null(会出空指针异常)
            Cell cellCurrent = row.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String stringValue = cellCurrent.getStringCellValue();
            // 把当前的属性名字添加在容器数组里去
            bialiangs[i] = stringValue;
        }
        /** -----获得第一行的数据（属性/变量）--结束----------------------------- */
        /** -----获得除了第一行的数据（属性/变量的值）--开始----------------------------- */
        // 获的最大的行数
        int lastRowNum = sheetAt.getLastRowNum();
        // 循环遍历获得索引的列（0到最大列）
        for (int i = 1; i <= lastRowNum; i++) {
            Person person = new Person();
            // 获得当前行
            Row row2 = sheetAt.getRow(i);
            // 遍历所有的数据行
            for (int j = 0; j < lastCellNum; j++) {
                Cell cellCurrent = row2.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                // 读取数据前设置单元格类型
                cellCurrent.setCellType(CellType.STRING);
                // 当前列的值
                String stringCellValue = cellCurrent.getStringCellValue();
                // System.out.print(stringCellValue + " ");
                /*
                 * if (j==0) { person.setId(stringCellValue); }else if (j==1) {
                 * person.setName(stringCellValue); }else if (j==2) {
                 * person.setSex(stringCellValue); }else if (j==3) {
                 * person.setAge(stringCellValue); }
                 */
                // 获得当前列的属性名字
                String bialiangs_values = bialiangs[j];
                // (反射)
                // 设setXxx方法
                String method = "set" + (bialiangs_values.charAt(0) + "").toUpperCase() + bialiangs_values.substring(1);
                // 获得类字节码对象
                Class<Person> pClass = Person.class;
                // 获得setXxx方法
                Method methodSet = pClass.getMethod(method, String.class);
                // 反射调用，将当前列的值stringCellValue，设置为person的所有属性的值
                methodSet.invoke(person, stringCellValue);
            }
            pList.add(person);
        }
        /** -----获得除了第一行的数据（属性/变量的值）--结束----------------------------- */
        return pList;
    }

}
