package com.study.algo;

import java.util.Scanner;

public class BOJ10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
				's','t','u','v','w','x','y','z'};
		
		for(int i=0; i<alphabet.length; i++) {
			System.out.print(s.indexOf(alphabet[i]) + " ");
		}
		sc.close();
	}
}