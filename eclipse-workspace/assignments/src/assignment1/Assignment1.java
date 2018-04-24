package assignment1;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Assignment1 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int check=1;
	while(check==1) {
		String givenRegex;
		
		System.out.println("Enter the regular expression");
		givenRegex = scan.next();
		printMatching(new File("/home/zemoso"),givenRegex);
		System.out.println("to continue enter 1 or 0 to stop");
		check=scan.nextInt();
	}
	scan.close();
	
}
private static void printMatching(File dir,String givenRegex) {
	FilenameFilter subDirs = new FilenameFilter() {
		public boolean accept(File dir,String name) {
			return new File(dir,name).isDirectory();
		}
	};
	File[] subDirectories = dir.listFiles(subDirs);
	FilenameFilter filter  = new FilenameFilter(){
		public boolean accept(File dir,String name) {
			return name.matches(givenRegex);
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
			printMatching(subDirectories[i],givenRegex);
		}
	}
}
}
