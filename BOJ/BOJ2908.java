package com.study.algo;

import java.util.Scanner;

public class BOJ2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		
		StringBuilder result1 = new StringBuilder();
		StringBuilder result2 = new StringBuilder();
		for(int i=2; i>=0; i--) {
			result1.append(num1.charAt(i));
			result2.append(num2.charAt(i));
		}
		
		if(Integer.parseInt(result1.toString()) > Integer.parseInt(result2.toString()))
			System.out.println(result1);
		else
			System.out.println(result2);	
		sc.close();
	}
}
//til
//int to String
//String to int