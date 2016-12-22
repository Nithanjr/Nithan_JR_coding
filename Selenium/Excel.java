package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;


public class Excel {
  
	@Test
  public void excelfile() throws IOException  {
		
		try{
			
		File src=new File("/home/ramadmin/Desktop/Excel.xls");
		FileInputStream fis=new FileInputStream(src);
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sh=wb.getSheetAt(0);
		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
		System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sh.getRow(0).getCell(2).getStringCellValue());
		System.out.println(sh.getRow(0).getCell(3).getStringCellValue());
		System.out.println(sh.getRow(0).getCell(4).getStringCellValue());
		sh.createRow(1).createCell(0).setCellValue("Roopesh");
		sh.getRow(1).createCell(1).setCellValue("Roopeshh@gmail.com");
		sh.getRow(1).createCell(2).setCellValue("Pass");
		sh.getRow(1).createCell(3).setCellValue("14-11-2016");
		sh.createRow(2).createCell(0).setCellValue("Nithan");
		sh.getRow(2).createCell(1).setCellValue("nithan34@gmail.com");
		sh.getRow(2).createCell(2).setCellValue("Pass");
		sh.getRow(2).createCell(3).setCellValue("06-11-2016");

	
		FileOutputStream fos=new FileOutputStream("/home/ramadmin/Desktop/Excel.xls");
				wb.write(fos);
				fos.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
			
		
  }

	
}
