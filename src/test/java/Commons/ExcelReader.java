package Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	String [] [] userdata = new String [100] [100];
	ArrayList<String> actualcellvalue = new ArrayList<String>();
	int i = 0,j=0;
	String sheetname = "userapidata";

public String readExcelSheet(int rowvalue, int colvalue) throws IOException {
	
		String path = System.getProperty("user.dir")+"/src/test/resources/testdata/userapi.xlsx";
		File Excelfile = new File(path);
		
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		Iterator<Row> row = sheet.rowIterator();
		
		while(row.hasNext()) {
			
			Row currRow = row.next();
			Iterator<Cell> cell = currRow.cellIterator();
			
			while(cell.hasNext()) {
				Cell currCell = cell.next();
				i=currCell.getRowIndex();
				j=currCell.getColumnIndex();
				
				switch (currCell.getCellType()) {
			    case STRING:
			    	userdata[i][j] = currCell.getStringCellValue();
			        break;
			    case NUMERIC:
			    	double numericValue  = currCell.getNumericCellValue();
			        BigDecimal bd = new BigDecimal(numericValue);
			        userdata[i][j] = bd.toPlainString();
			        userdata[i][j] = userdata[i][j].replaceAll("\\.0", "");
			        break;
			        
				}
			}
		}
		workbook.close();
		String cellvalue = userdata[rowvalue][colvalue];
		return cellvalue;
	}

public String getuserdata(int rownumber,int colnum) throws IOException {
	String userdata = null;	
	userdata = readExcelSheet(rownumber, colnum);
	LoggerLoad.info("User data is "+userdata);
	return userdata;	
}



}