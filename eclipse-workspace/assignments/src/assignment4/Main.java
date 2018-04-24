package assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	//extracting year from given date
	Instant instant = currentDate.toInstant();
	ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
	LocalDate testDate = zdt.toLocalDate();
	int cyear = testDate.getYear();
	//creating and updating the anniversary Date
	Calendar aCal = Calendar.getInstance();
	aCal.setTime(signDate);
	aCal.set(Calendar.YEAR,cyear);
	//finding the range
	aCal.add(Calendar.DATE,30);
	Date preDate = aCal.getTime();
	aCal.add(Calendar.DATE,-60);
	Date postDate = aCal.getTime();
	if(currentDate.before(preDate)){
		preDate = currentDate;
	}

	System.out.println(dateFormat.format(postDate)+" "+dateFormat.format(preDate));


}


}
