package com.study.algo;

import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alphabet = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String sentence = sc.next();
		int count = 0;
		
		while(sentence.length() > 0) {
			for(int i=0; i<8; i++) {//알파벳들 검사
				int idx = sentence.indexOf(alphabet[i]);
				if( idx != -1) {//찾으면
					count++;
					String original = sentence;
					sentence = sentence.substring(0,idx) +" " +original.substring(idx+ alphabet[i].length());
					break;
					//이쪽 부분도! 여기 break를 안해버리면 c==dz=dddz==여기 제대로 통과 못해! 뒤에 있는 dz=가 아니라 z=로 생각하고 받아들여짐.
				}
			}
			
			if( !sentence.contains("c=") && !sentence.contains("c-") && !sentence.contains("dz=") && !sentence.contains("d-")&& !sentence.contains("lj")  && !sentence.contains("nj")&& !sentence.contains("s=")&& !sentence.contains("z=")) {
				//여기 =나 -도 알파벳으로 센다는 것을 잊음.
				sentence = sentence.replace(" ", ""); 
				count += sentence.length();
				sentence = "";
			}
		}
		System.out.println(count);
		sc.close();
	}
}
