package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i=1; i<=10; i++) {
			int n = sc.nextInt();
			String input = sc.next();

			while(n/2>0) {
				if(input.length() == 0) break;
				input = input.replace("()", "").replace("[]", "").replace("<>", "").replace("{}", "");
				n--;
			}
			
			System.out.println(input.length() == 0? "#"+i+" "+1 : "#"+i+" "+0);
		}
	}
}