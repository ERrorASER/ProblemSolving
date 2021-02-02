package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc<=t; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			//현재 위치
			int dx = 0;
			int dy = 0;
			
			//우,하,좌,상
			int[] x = {0,1,0,-1};
			int[] y = {1,0,-1,0};

			int idx = 0;
			
			for(int i=1; i<=n*n; i++) {
				map[dx][dy] = i;
				dx += x[idx];
				dy += y[idx];
				
				//인덱스 바꿔주기
				if(dx>=n || dy>= n ||dy<0 ||dx<0 || map[dx][dy] != 0) {//방향 바꿀 때, 
					//잘못된 애들 빼주고, 
					dx -= x[idx];
					dy -= y[idx];
					idx = (idx+1)%4;
					//새로운 방향으로 더해줌.
					dx += x[idx];
					dy += y[idx];
				}
				

			}
			
			
			System.out.println("#"+tc);
			for(int i=0; i<n;i++) {
				for(int j=0; j<n; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		
		
		sc.close();
	}

}
