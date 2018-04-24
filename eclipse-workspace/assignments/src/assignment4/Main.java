package assignment4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String signUpDate,currDate;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the signup date date and current date ");
		signUpDate = scan.next();
		currDate = scan.next();
		findRange(signUpDate,currDate);
		scan.close();
	}

	private static void findRange(String signUpDate, String currDate) {
		//getting the signup date
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
		//checking if the sign up is in future date
		if(signYear>currYear) {
			System.out.println("no range");
			return;
		}else if(signYear==currYear) { // case where sign up  happens in same year
			//considering months as it is in same year
			
			if(signMonth>currMonth) { //checking if it is happening in future Date
				System.out.println("no range");
				return;
			}else if(signMonth==currMonth) { // case where sign up is in same month
				if(signDay>currDay) { //checking if it is happening in future Date
					System.out.println("no range");
					return;
				}else { //cases when in same month and same year
					 postDate = 30-signDay;
					if(postDate==0) {
						postMonth= signMonth-1;
						if(postMonth==0) {
							postYear=currYear-1;
						}
						postDate = monthDays[postMonth-1];
						postYear = currYear;
					}else if(postDate<0) {
						postMonth = signMonth;
						postDate = -1*postDate;
						postYear = currYear;
					}else {
						postMonth= signMonth-1;
						if(postMonth==0) {
							postYear=currYear-1;
						}
						postDate = monthDays[postMonth-1]-postDate;
					}
					
					preDate=currDay;
					preMonth =currMonth;
					preYear = currYear;
					
				}
			}else { // case when different Months same year
				 postDate = 30-signDay;
					if(postDate==0) {
						postMonth= signMonth-1;
						if(postMonth==0) {
							postYear=currYear-1;
						}
						postDate = monthDays[postMonth-1];
						postYear = currYear;
					}else if(postDate<0) {
						postMonth = signMonth;
						postDate = -1*postDate;
					}else {
						postMonth= signMonth-1;
						if(postMonth==0) {
							postYear=currYear-1;
						}
						postDate = monthDays[postMonth-1]-postDate;
						postYear = currYear;
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
				
			}
		}else { //case when different year same as different months
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
		}
		System.out.println(postDate+"-"+postMonth+"-"+postYear+" "+preDate+"-"+preMonth+"-"+preYear);
		
	}

}
