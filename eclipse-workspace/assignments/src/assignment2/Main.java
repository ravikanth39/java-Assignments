package assignment2;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scan  =  new Scanner(System.in);
System.out.println("Input the String");
String givenString = scan.nextLine();
boolean res = checkallAlpha(givenString);
if(res) {
	System.out.println("given String contains ALL 26 alphabets");
}
else {
	System.out.println("given String does not contain all strings");
}
scan.close();
}

private static boolean checkallAlpha(String s) {
	s = s.replaceAll("[^a-zA-Z]",""); // regex to remove non alpahbetical characters
	s = s.toLowerCase();
	s = s.replaceAll("(.)(?=.*\\1)", ""); //regex to remove all duplicates
	
	return (s.length()==26);
}
}
