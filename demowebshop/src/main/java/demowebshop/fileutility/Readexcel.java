package demowebshop.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;

public class Readexcel {
	
	FileInputStream fis;
	Workbook wb;

	public Object[][] getmultipledata(String sheetname) {
		try {
			fis=new FileInputStream("./src/test/resources/users.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Sheet sheet=wb.getSheet(sheetname);
//		Row row =sheet.getRow(0);
//		Cell cell =row.getCell(1);
//		String data =cell.getStringCellValue();
		
		Sheet sheet=wb.getSheet(sheetname);
		int rowcount =sheet.getPhysicalNumberOfRows();
		int cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowcount-1][cellcount];
		for (int i=1;i<rowcount;i++) {
			for (int j=0;j<cellcount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
						
			}
			
		}
		return data;

			
		
	}	
	public static void main(String[] args) {
		Readexcel read =new Readexcel();
		Object[][] data=read.getmultipledata("sheet1");
		for (int i=0;i<data.length;i++){
			for (int j=0;j<2;j++) {
				System.out.println(data[i][j]);
			}
		}
			
	
	}
}
		
  

	
	
	
