package com.study.algo;

import java.util.Scanner;

public class SSAFY1 {
	static String src = "3\r\n" + 
			"6\r\n" + 
			"S A S S W S \r\n" + 
			"S W A S C S\r\n" + 
			"S W S W S S\r\n" + 
			"S W S S W S\r\n" + 
			"S B S S W S\r\n" + 
			"S S S S S S\r\n" + 
			"3\r\n" + 
			"S S A \r\n" + 
			"B W W \r\n" + 
			"S W C \r\n" + 
			"10\r\n" + 
			"C S S S S S S S S C\r\n" + 
			"S W S S S S S S W S\r\n" + 
			"S S W S S S S W S S\r\n" + 
			"A S S W S S W S S A\r\n" + 
			"S S S S S B S S S S\r\n" + 
			"S S S S B S S S S S \r\n" + 
			"A S S W S S W S S A\r\n" + 
			"S S W S S S S W S S\r\n" + 
			"S W S S S S S S W S\r\n" + 
			"C S S S S S S S S C";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int tc = sc.nextInt();
		int n;
		//상,하,좌,우
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i=1; i<=tc; i++) {
			int result = 0;//답
			n = sc.nextInt();
			char[][] room = new char[n][n];
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					room[j][k] = sc.next().charAt(0);
				}
			}//방생성 코드
			
			for(int j=0; j<n; j++) {//j는 x축
				for(int k=0; k<n; k++) {//k는 y축
					if(room[j][k] == 'A') {//A를 만나면
						
						for(int m=1; m<n; m++) {
							int my = k + m;
							// k , k+1, k+2, k+3 <n
							if(my >= 0 && my <n) {//칸을 안넘을 때
								if(room[j][my] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//A
						
						
					}else if(room[j][k] == 'B') {
						
						for(int m=1; m<n; m++) {
							int my = k + m;
							// k , k+1, k+2, k+3 <n
							if(my >= 0 && my <n) {//칸을 안넘을 때
								if(room[j][my] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//우
						
						for(int m=1; m<n; m++) {
							int my = k - m;
							// k , k+1, k+2, k+3 <n
							if(my >= 0 && my <n) {//칸을 안넘을 때
								if(room[j][my] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//좌
						
					}else if(room[j][k] == 'C') {
						for(int m=1; m<n; m++) {
							int my = k + m;
							// k , k+1, k+2, k+3 <n
							if(my >= 0 && my <n) {//칸을 안넘을 때
								if(room[j][my] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//우
						
						for(int m=1; m<n; m++) {
							int my = k - m;
							// k , k+1, k+2, k+3 <n
							if(my >= 0 && my <n) {//칸을 안넘을 때
								if(room[j][my] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//좌
						
						for(int m=1; m<n; m++) {
							int mx = k - m;
							// k , k+1, k+2, k+3 <n
							if(mx >= 0 && mx <n) {//칸을 안넘을 때
								if(room[mx][k] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//상
						
						for(int m=1; m<n; m++) {
							int mx = k + m;
							// k , k+1, k+2, k+3 <n
							if(mx >= 0 && mx <n) {//칸을 안넘을 때
								if(room[mx][k] == 'S') {
									result++;
									
								}else {
									break;
								}
								
							}else {//칸 넘을 때
								break;
							}
						}//하
					}
				}
			}//방생성 코드
			

			System.out.println("#"+i+" "+result);
		}//테스트케이스
		sc.close();
	}
}
