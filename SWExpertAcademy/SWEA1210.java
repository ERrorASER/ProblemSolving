package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc<10; tc++) {
			int t = sc.nextInt();

			int exit = 0;
			int[][] map = new int[100][100];
			
			for(int i=0; i<100; i++) {//map 생성
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<100; i++) {//x찾기
				if(map[99][i] == 2)
					exit = i;//99,exit
			}
			
			int dx = 99;//현재 위치x
			int dy = exit;//현재 위치y
			while(true) {

				if(dx>0 && dy>=0 && dx<=99 && dy<=99) {//범위 내인가?
					if(dy-1>0 && map[dx][dy-1] == 1) {//좌측으로 갈 수 있다면
						map[dx][dy] = 0;
						dy--;
						
					}else if(dy+1<=99 && map[dx][dy+1] == 1) {//우측으로 갈 수 있다면
						map[dx][dy] = 0;
						dy++;
						
					}else {//다 못가면 위로만 이동
						map[dx][dy] = 0;
						dx--;
						
					}
				}else if(dx == 0) {
					break;
				}
			}

			System.out.println("#"+t+" "+dy);
		}
		
		
		sc.close();
	}

}
