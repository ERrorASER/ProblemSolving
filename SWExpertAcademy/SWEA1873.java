package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1873 {

	public static int getDirection(char a) {
		if(a == '^' || a == 'U') {
			return 0;
		}else if(a == 'v' || a == 'D') {
			return 1;
		}else if(a == '<' || a == 'L') {
			return 2;
		}else if(a == '>' || a == 'R'){
			return 3;
		}else {
			return -1;
		}
	}
	
	public static char showDirection(int a) {
		if(a == 0) {
			return '^';
		}else if(a == 1) {
			return 'v';
		}else if(a == 2) {
			return '<';
		}else{
			return '>';
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();//test case
		for(int tc = 1; tc<=t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int x = 0,y = 0;
			int d = 0; //U : 0, D : 1, L : 2, R : 3

			char[][] map = new char[h][w];
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};

			for(int i=0; i<h; i++) {//map생성, 전차위치 저장
				String line = sc.next();
				for(int j=0; j<w; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<' || map[i][j]=='>') {//전차위치
						x = i;
						y = j;
						d = getDirection(map[i][j]);
					}
				}
			}

			//n문자열
			int n = sc.nextInt();
			String sentence = sc.next();
			int[] input = new int[n];
			for(int i=0; i<n; i++) {
				input[i] = getDirection(sentence.charAt(i));
			}

			for(int i=0; i<n; i++) {
				//이동
				if(input[i]>=0 && input[i]<4) {//0~3
					x += dx[input[i]];
					y += dy[input[i]];
					d = input[i];
					if(x>=0 && y>=0 && x<h && y<w && map[x][y] =='.') {//범위 내에 있으면 이동
						map[x][y] = map[x-dx[input[i]]][y-dy[input[i]]];//이동
						map[x-dx[input[i]]][y-dy[input[i]]] = '.';
					}else {//전차가 범위 밖
						x -= dx[input[i]];
						y -= dy[input[i]];
					}
				}
				//포탄 발사
				else if(input[i] == -1) {
					if(d == 0) {//위,아래 => x만 바뀌고 y는 그대로
						for(int j= x-1; j>=0; j--) {
							if(map[j][y]=='*' ) {
								map[j][y] = '.';
								break;
							}else if(map[j][y] == '#') {
								break;
							}
						}
					}else if(d ==1) {//위,아래
						for(int j= x+1; j<h; j++) {
							if(map[j][y]=='*' ) {
								map[j][y] = '.';
								break;
							}else if(map[j][y] == '#') {
								break;
							}
						}
					}else if(d ==2) {//좌
						for(int j= y-1; j>=0; j--) {//y만 바뀐다.
							if(map[x][j]=='*' ) {
								map[x][j] = '.';
								break;
							}else if(map[x][j] == '#') {
								break;
							}
						}
					}else if(d ==3) {//우
						for(int j= y+1; j<w; j++) {//y만 바뀐다.
							if(map[x][j]=='*' ) {
								map[x][j] = '.';
								break;
							}else if(map[x][j] == '#') {
								break;
							}
						}
					}

				}
			}
			
			map[x][y] = showDirection(d);

			
			//결과물 출력
			System.out.print("#"+tc+" ");
						for(int i=0; i<h; i++) {
							for(int j=0; j<w; j++) {
								System.out.print(map[i][j]);
							}
							System.out.println();
						}	
		}
	}
}
