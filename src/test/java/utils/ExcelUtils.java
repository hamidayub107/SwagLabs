package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getData(int rowNum, int colNum) {
		String getCellData = null;
		try {
		getCellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return getCellData;
	}
}
