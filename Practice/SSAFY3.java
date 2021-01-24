package com.study.algo;
import java.util.Scanner;

public class SSAFY3 {
	static String src = "3\r\n" + 
			"8 5 3 4\r\n" + 
			"1 8 5 5 1 2 6 7\r\n" + 
			"5\r\n" + 
			"1 3 2 1 3 1 4 1 1 2\r\n" + 
			"7 4 4 4\r\n" + 
			"1 7 5 5 1 2 6 3\r\n" + 
			"4\r\n" + 
			"4 3 3 1 2 2 3 2\r\n" + 
			"5 1 1 1\r\n" + 
			"1 2\r\n" + 
			"5\r\n" + 
			"3 2 2 1 3 3 2 4 3 1";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		
		int tc = sc.nextInt();
		int n;
		int[] dx = {0,-1,0,1,0};
		int[] dy = {0,0,1,0,-1};
		
		for(int t = 1; t<=tc; t++) {
			n = sc.nextInt(); //배열크기
			int x = sc.nextInt(); //출발좌표
			int y = sc.nextInt();
			int jumper = sc.nextInt();//점퍼의 개수
			
			int[][] space = new int[n][n];//방
			for(int i=0; i<jumper; i++) {
				int jx = sc.nextInt();
				int jy = sc.nextInt();
				space[jx-1][jy-1] = 1;
			}//방에다 점퍼 좌표 1로 표시
			
			int moveCount = sc.nextInt();//이동지시 개수
			for(int i=0; i<moveCount; i++) {//이동지시만큼 이동
				int d = sc.nextInt();
				int move = sc.nextInt();
				
				x += dx[d] * move;
				y += dy[d] * move;
				
				if(x>=0 && x<n && y>=0 && y<n ) {//점퍼를 만났거나, 칸을 벗어났을 시,
					if(space[x-1][y-1] == 1) {
						System.out.println("#"+t+" 0 0");
						break;
					}
				}else {
					System.out.println("#"+t+" 0 0");
					break;
				}
				
				if(i==moveCount-1) {
					System.out.println("#"+t+" " + x + " " +y);
				}
			}		
		}//테스트 케이스
		sc.close();
	}
}
