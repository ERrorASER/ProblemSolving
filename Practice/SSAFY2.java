package com.study.algo;

import java.util.Scanner;

public class SSAFY2 {
	static String src = "3\r\n" + 
			"9 5\r\n" + 
			"6 2 2\r\n" + 
			"1 5 1\r\n" + 
			"0 0 2\r\n" + 
			"1 0 1\r\n" + 
			"2 4 2\r\n" + 
			"11 6\r\n" + 
			"0 0 2\r\n" + 
			"1 0 1\r\n" + 
			"2 4 2\r\n" + 
			"6 2 2\r\n" + 
			"1 5 1\r\n" + 
			"8 3 2\r\n" + 
			"7 5\r\n" + 
			"6 2 2\r\n" + 
			"1 6 1\r\n" + 
			"0 0 2\r\n" + 
			"1 0 1\r\n" + 
			"2 4 2";
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int t = sc.nextInt();
		int n, bugs;
		int[] x = {0,1,0};
		int[] y = {0,0,1};
		
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			bugs = sc.nextInt();
			
			boolean flag = false;
			
			int[][] pond = new int[n][n];//안뛴자리는 0, 뛴자리는 1
			
			for(int j=0; j<bugs; j++) {
				int dx = sc.nextInt();
				int dy = sc.nextInt();
				int d = sc.nextInt();
				
				//시작위치가 이미 뛰었던 자리(1)이면  번호 출력 아니면(0) 진행
				if(pond[dx][dy] == 0) {
					for(int jump = 3; jump>0; jump--) {
						dx += jump*x[d];
						dy += jump*y[d];
						
						//뛴 위치가 연못 밖이면 멈추고, 아니라면 계속 진행
						if(dx>=0 && dx <n && dy>=0 && dy<n) {//연못 안
							//뛴 장소가 이미 뛰었던 자리인가? 그러면 출력 후 종료, 아니라면 자리 저장 후 계속
							if(pond[dx][dy] == 0) {
								pond[dx][dy] = 1;
							}else {//뛰었던 자리
								System.out.println("#"+(i+1)+" " + (j+1));
								flag = true;
								break;
							}
						}else {//연못 밖
							break;
						}						
					}//소금쟁이들 3번씩 뛰기		
				}else {
					System.out.println("#"+(i+1)+" " + (j+1));
					flag = true;
					break;
				}
								
			}//소금쟁이들 
			if(!flag) {
				System.out.println("#"+(i+1)+" 0");
			}
		}//테스트 케이스
		sc.close();
	}
}