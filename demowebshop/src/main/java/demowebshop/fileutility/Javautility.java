package demowebshop.fileutility;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Javautility {
	
	public int generaterandom(int range) {
		Random ran=new Random();
		int randomnumber =ran.nextInt(range);
		return randomnumber;
	}
	public String GetSystemDate() {
		java.util.Date dateobjDate=new java.util.Date();
		String date=dateobjDate.toString();
		return date.replace("", "_").replace(":", "_");	
	}
	public void getsystemdateindd_MM_YYYY() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateobj=new java.util.Date();
		String date=sdf.format(dateobj);
		System.out.println(date);
	
	}
	

}
