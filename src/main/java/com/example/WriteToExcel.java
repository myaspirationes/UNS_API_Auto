package com.example;

import java.io.File;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class WriteToExcel {
	public void readTO() {
        Workbook wb = null;
        WritableWorkbook wwb = null;
        try {
            File is = new File(System.getProperty("user.dir") + "\\in.xls");
            File os = new File(System.getProperty("user.dir") + "\\out.xls");
            if (!os.isFile())// 如果指定文件不存在，则新建该文件
                os.createNewFile();

            wb = Workbook.getWorkbook(is);// 获取数据源in.xls工作簿对象
            wwb = Workbook.createWorkbook(os, wb);// 在原有工作簿out.xls上追加数据
            // wwb = Workbook.createWorkbook(os);//区别于上一行代码，创建一个新的写入工作簿
            if (wb != null && wwb != null) {

                WritableSheet sheet = wwb.getSheet(0);// 获取out.xls第一个sheet
                WritableCell cell = sheet.getWritableCell(2, 4);// 获取out.xls要写入数据的单元格

                Sheet[] sheets = wb.getSheets();// 获取数据源in.xls的sheets
                Cell[] cells = sheets[0].getRow(1);// 获取in.xls第一个sheet的第二行
                if (cell.getType() == CellType.LABEL) {
                    Label l = (Label) cell;
                    l.setString(cells[1].getContents());// 将第二个单元格写入out.xls的第三列第五行
                }
                wwb.write();
                System.out.println("工作簿写入数据成功！");
            }
            wwb.close();// 关闭
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wb.close();
        }
    }
}