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
		File dir = new File("/home/zemoso");
		FilenameFilter filter  = new FilenameFilter(){
			public boolean accept(File dir,String name) {
				return name.matches(givenRegex);
			}
		};
		String[] files = dir.list(filter);
		if(files==null) {
			System.out.println("No files matching the given regex");
		} else {
			System.out.println(files.length);
			for(int i=0;i<files.length;i++) {
				String fileName = files[i];
				System.out.println(fileName+"   "+new File(fileName).getAbsolutePath());
			}
		}
		
		System.out.println("to continue enter 1 or 0 to stop");
		check=scan.nextInt();
	}
	scan.close();
	
}
}
