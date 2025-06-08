package Commons;

import java.io.IOException;

public class DataReader {
	int colnum;
	
	public String userdata(int rownum, String fieldname) throws IOException {
	ExcelReader read = new ExcelReader();
	
	if(fieldname.contentEquals("userFirstName"))
		colnum=0;
	else if (fieldname.contentEquals("userLastName"))
		colnum=1;
	else if (fieldname.contentEquals("userContactNumber"))
		colnum=2;
	else if (fieldname.contentEquals("userEmailId"))
		colnum=3;
	else if (fieldname.contentEquals("plotNumber"))
		colnum=4;
	else if (fieldname.contentEquals("street"))
		colnum=5;
	else if (fieldname.contentEquals("state"))
		colnum=6;
	else if (fieldname.contentEquals("country"))
		colnum=7;
	else if (fieldname.contentEquals("zipCode"))
		colnum=8;
	else if (fieldname.contentEquals("caseno"))
		colnum=9;
	else if (fieldname.contentEquals("code"))
		colnum=10;
	else if (fieldname.contentEquals("message"))
		colnum=11;
	else if (fieldname.contentEquals("endpoint"))
		colnum=12;
	else if (fieldname.contentEquals("testtype"))
		colnum=13;
	else if (fieldname.contentEquals("userid"))
		colnum=14;
	else if (fieldname.contentEquals("patchbody"))
		colnum=15;
	else if (fieldname.contentEquals("username"))
		colnum=16;
	else if (fieldname.contentEquals("password"))
		colnum=17;

	String userdata = read.getuserdata(rownum,colnum);
	System.out.println(userdata);
	return userdata;
	}
	
	

}
