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
			        
//			    case BOOLEAN:
//			        userdata[i][j] = currCell.getBooleanCellValue();
//			        break;
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

/*
  public ArrayList<String> readuserdata(int rowvalue, int colvalue) throws IOException {
	
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
			userdata[i][j] = currCell.getStringCellValue();
		}
	}
	workbook.close();
	actualcellvalue.add(userdata[rowvalue][colvalue]);
	System.out.println(actualcellvalue);
	return actualcellvalue;
}

public String getuserdata(int rownumber, int colnum) throws IOException {
	ArrayList<String> actualuserdata = new ArrayList<String>();
	actualuserdata = readuserdata(rownumber, colnum);
	String userdata = actualuserdata.toString();
	LoggerLoad.info(userdata);
	return userdata;
}
public String getuserFirstName(int rownumber) throws IOException {
	String userFirstName = null;	
	userFirstName = readExcelSheet(rownumber, 0);
	LoggerLoad.info("User Firstname is "+userFirstName);
	return userFirstName;	
}
public String getuserLastName(int rownumber) throws IOException {
	String getuserLastName = null;	
	getuserLastName = readExcelSheet(rownumber, 1);
	LoggerLoad.info("User LastName is "+getuserLastName);
	return getuserLastName;	
}

public String userContactNumber(int rownumber) throws IOException {
	String userContactNumber = null;	
	userContactNumber = readExcelSheet(rownumber, 2);
	LoggerLoad.info("userContactNumber is "+userContactNumber);
	return userContactNumber;	
}
public String userEmailId(int rownumber) throws IOException {
	String userEmailId = null;	
	userEmailId = readExcelSheet(rownumber, 3);
	LoggerLoad.info("userEmailId is "+userEmailId);
	return userEmailId;	
}
public String plotNumber(int rownumber) throws IOException {
	String plotNumber = null;	
	plotNumber = readExcelSheet(rownumber, 4);
	LoggerLoad.info("plotNumber is "+plotNumber);
	return plotNumber;	
}
public String street(int rownumber) throws IOException {
	String street = null;	
	street = readExcelSheet(rownumber, 5);
	LoggerLoad.info("street is "+street);
	return street;	
}
public String state(int rownumber) throws IOException {
	String state = null;	
	state = readExcelSheet(rownumber, 6);
	LoggerLoad.info("state is "+state);
	return state;	
}
public String country(int rownumber) throws IOException {
	String country = null;	
	country = readExcelSheet(rownumber, 7);
	LoggerLoad.info("country is "+country);
	return country;	
}
public String zipCode(int rownumber) throws IOException {
	String zipCode = null;	
	zipCode = readExcelSheet(rownumber, 8);
	LoggerLoad.info("zipCode is "+zipCode);
	return zipCode;	
}
public String caseno(int rownumber) throws IOException {
	String caseno = null;	
	caseno = readExcelSheet(rownumber, 9);
	LoggerLoad.info("caseno is "+caseno);
	return caseno;	
}
public String code(int rownumber) throws IOException {
	String code = null;	
	code = readExcelSheet(rownumber, 10);
	LoggerLoad.info("code is "+code);
	return code;	
}
public String message(int rownumber) throws IOException {
	String message = null;	
	message = readExcelSheet(rownumber, 11);
	LoggerLoad.info("message is "+message);
	return message;	
}
public String endpoint(int rownumber) throws IOException {
	String endpoint = null;	
	endpoint = readExcelSheet(rownumber, 12);
	LoggerLoad.info("endpoint is "+endpoint);
	return endpoint;	
}
public String testtype(int rownumber) throws IOException {
	String testtype = null;	
	testtype = readExcelSheet(rownumber, 13);
	LoggerLoad.info("testtype is "+testtype);
	return testtype;	
}
public String userid(int rownumber) throws IOException {
	String userid = null;	
	userid = readExcelSheet(rownumber, 14);
	LoggerLoad.info("User id is "+userid);
	return userid;	
}
public String patchbody(int rownumber) throws IOException {
	String patchbody = null;	
	patchbody = readExcelSheet(rownumber, 15);
	LoggerLoad.info("patchbody is "+patchbody);
	return patchbody;	
}
public String username(int rownumber) throws IOException {
	String username = null;	
	username = readExcelSheet(rownumber, 16);
	LoggerLoad.info("username is "+username);
	return username;	
}
public String password(int rownumber) throws IOException {
	String password = null;	
	password = readExcelSheet(rownumber, 17);
	LoggerLoad.info("password is "+password);
	return password;	
} */


}