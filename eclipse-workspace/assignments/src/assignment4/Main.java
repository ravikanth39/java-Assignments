package assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
public static void main(String[] args) throws ParseException {
	String signUpDate,currDate;
	Scanner scan = new Scanner(System.in);
	signUpDate = scan.next();
	currDate = scan.next();
	printRange(signUpDate,currDate);
	scan.close();
	
}

private static void printRange(String signUpDate, String currDate) throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Date signDate = dateFormat.parse(signUpDate);
	Date currentDate = dateFormat.parse(currDate);
	if(signDate.after(currentDate)) {
		System.out.println("No Range");
		return;
	}
	int signYear,signMonth,signDay;
	String[] sign = signUpDate.split("-");
	signYear = Integer.parseInt(sign[2]);
	signMonth = Integer.parseInt(sign[1]);
	signDay = Integer.parseInt(sign[0]);
	//getting the current date
	int currYear,currMonth,currDay;
	String[] curr = currDate.split("-");
	currYear = Integer.parseInt(curr[2]);
	currMonth = Integer.parseInt(curr[1]);
	currDay = Integer.parseInt(curr[0]);
	
	//number of days in the month
	int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	//checking for leap years
	if(currYear%4==0) {
		monthDays[1]=29;
	}
	int postDate,postMonth,postYear=currYear,preDate,preMonth,preYear;
	postDate = 30-signDay;
	if(postDate==0) {
		postMonth= signMonth-1;
		if(postMonth==0) {
			postYear=currYear-1;
		}
		postDate = monthDays[postMonth-1];
	}else if(postDate<0) {
		postMonth = signMonth;
		postDate = -1*postDate;
	}else {
		postMonth= signMonth-1;
		if(postMonth==0) {
			postYear=currYear-1;
		}
		postDate = monthDays[postMonth-1]-postDate;
	}
	
	preDate = monthDays[signMonth-1]-signDay;
	preDate = 30-preDate;
	if(monthDays[signMonth+1-1]<preDate) {
		preMonth = signMonth+2;
		preDate = preDate-monthDays[signMonth+1-1];

	}else {
		preMonth = signMonth+1;
	}
	preYear = currYear;
	if(preMonth>currMonth) {
		preDate = currDay;
		preMonth = currMonth;
		preYear = currYear;
	}
	if(preMonth==currMonth && preDate>currDay) {
		preDate = currDay;
	}
	System.out.println(postDate+"-"+postMonth+"-"+postYear+" "+preDate+"-"+preMonth+"-"+preYear);
	
}


}
