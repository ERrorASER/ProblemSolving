package com.study.algo;

import java.util.Scanner;

public class BOJ1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = 0;
		for(int i=1; i<s.length(); i++) {
			
			if(s.charAt(i-1) == ' ' )
				count++;
		}
		if(s.charAt(0) != ' ') count++;
		System.out.println(count);
		sc.close();
	}
}
