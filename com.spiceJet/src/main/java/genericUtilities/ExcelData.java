package genericUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelData 
{


	private FileInputStream testData;
	File file;
	private Workbook book;
	private FileOutputStream fos;

public ExcelData() 
	{
		try {
			file = new File("C:\\Users\\Giris\\Interview\\com.spiceJet\\src\\test\\resources\\TestDataSJ.xlsx");
//			testData = new FileInputStream("C:\\Users\\Giris\\Interview\\com.spiceJet\\src\\test\\resources\\TestDataSJ.xlsx");
		} catch (Exception e) {
			
		}
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (EncryptedDocumentException e) {
			
		}  catch (IOException e) {
			
		}	
	}



	public String getaDataFromExcel(String sheetName, int rowNumber, int cellNumber) 
	{
		String data = book.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString().trim();
		return data;

	}



	
	public int getLastRowNumOfExcel(String sheetName)
	{

		int lastRowNumber = book.getSheet(sheetName).getLastRowNum();
		return lastRowNumber;
	}





	
	public int getLastCellNumOfExcel(String sheetName, int rowNumber)
	{
		int lastCellNumber = book.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
		return lastCellNumber;		
	}



	
	public void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String result)
	{	
		book.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(result);

		try {
			fos = new FileOutputStream(new PropertyFileData().getProperty("excelPath"));
			try {
				book.write(fos);
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {

		}
	}



	
	public void closeExcel()
	{
		try {
			testData.close();
		} catch (IOException e) {
			System.out.println("No file to Close");
		}
		try {
			book.close();
		} catch (IOException e) {
			System.out.println("No book to Close");
		}
		try {
			fos.close();
		} catch (IOException e) {
			System.out.println("nothing to close");
		}
	}
}
