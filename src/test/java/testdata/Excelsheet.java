package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
	
	public static Workbook book;
	public static Sheet Sheet;

public static Object [][] readdata(String Sheetname){
	FileInputStream file=null;
	
	try {
		file=new FileInputStream("C:\\Users\\harma\\eclipse-workspace\\Orangehm\\src\\test\\java\\testdata\\details.xlsx");
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
	
		
	 book=		WorkbookFactory.create(file);
	
}
	catch(IOException a) {
		a.printStackTrace();}
	
	 Sheet=	book.getSheet(Sheetname);
	
	
	Object [][] data =new Object [Sheet.getLastRowNum()] [Sheet.getRow(0).getLastCellNum()];
	
	for (int i=0;i<Sheet.getLastRowNum();i++) {
		for (int k=0;k<Sheet.getRow(0).getLastCellNum(); k++) {	
			data[i][k]= Sheet.getRow(i+1).getCell(k).toString();
		}
		
	}
	return data;
	
	}
	
	
	
	
	
}
