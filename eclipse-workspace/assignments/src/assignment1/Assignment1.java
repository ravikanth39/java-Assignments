package assignment1;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;

public class Assignment1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int check=1;
	while(check==1) {
		String givenRegex;
		System.out.println("Enter the regular expression");
		givenRegex = scan.next();
		Pattern givenPattern = Pattern.compile(givenRegex);
		printMatching(new File("/home/zemoso"),givenPattern);
		System.out.println("to continue enter 1 or 0 to stop");
		try{
			check=scan.nextInt();
			if(check!=0||check!=1){
				throw new InputMismatchException("Invalid input,input should be either 1 or 0");
			}
		}catch (InputMismatchException e){
			System.out.println("Invalid input,input should be either 1 or 0");
			break;
		}
		finally {
			scan.close();
		}
	}
	scan.close();
	
}
private static void printMatching(File dir,Pattern givenPattern) {
	FilenameFilter subDirs = new FilenameFilter() {
		public boolean accept(File dir,String name) {
			return new File(dir,name).isDirectory();
		}
	};
	File[] subDirectories = dir.listFiles(subDirs);
	FilenameFilter filter  = new FilenameFilter(){
		public boolean accept(File dir,String name) {

			return givenPattern.matcher(name).matches();
		}
	};
	String[] files = dir.list(filter);
	if(files==null) {
	} else {
		for(int i=0;i<files.length;i++) {
			String fileName = files[i];
			System.out.println(fileName+"   "+new File(fileName).getAbsolutePath());
		}
	}
	if(subDirectories !=null) {
		for(int i=0;i<subDirectories.length;i++) {
			printMatching(subDirectories[i],givenPattern);
		}
	}
}
}
