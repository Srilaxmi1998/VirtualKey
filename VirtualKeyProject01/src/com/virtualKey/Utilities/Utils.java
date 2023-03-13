package com.virtualKey.Utilities;

import java.util.Scanner;

public class Utils {

	public static void printMessage(String msg) {
		System.out.println(msg);
	}
	static void filenameChecking(String filename) {
		if (filename == null || filename.isEmpty() || filename.isBlank())
			throw new NullPointerException("File Name cannot be Empty or null");
	}
	
	public static void pathChecking(String path) {
		if (path == null || path.isEmpty() || path.isBlank())
			throw new NullPointerException("Path cannot be Empty or null");
		
	}
	
	protected static int scanner() {
		Scanner sc = new Scanner(System.in);
		int input=Integer.parseInt(sc.nextLine());
		return input;
				    
	}
}
