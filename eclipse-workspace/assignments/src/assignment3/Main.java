package assignment3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	String host;
	Scanner scan  = new Scanner(System.in);
	System.out.println("enter the host IP address");
	host = scan.next();
	int timeTaken =0;
	try {
		timeTaken = hostPinged(host);
	} catch (IOException e) {
		e.printStackTrace();
	}
	if(timeTaken>0) {
		System.out.println("time taken to ping "+timeTaken+" milli seconds");
	}
	else {
		System.out.println("Unable to reach the Host");
	}
	scan.close();
	
}

private static int hostPinged(String host) throws UnknownHostException, IOException {
	Long startTime = System.currentTimeMillis();
	if(!InetAddress.getByName(host).isReachable(5000)) {
		return -1;
	}
	return (int)(System.currentTimeMillis()-startTime);
}
}
