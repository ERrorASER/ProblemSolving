package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc<10; tc++) {
			int t = sc.nextInt();

			int exit = 0;
			int[][] map = new int[100][100];
			
			for(int i=0; i<100; i++) {//map ����
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<100; i++) {//xã��
				if(map[99][i] == 2)
					exit = i;//99,exit
			}
			
			int dx = 99;//���� ��ġx
			int dy = exit;//���� ��ġy
			while(true) {

				if(dx>0 && dy>=0 && dx<=99 && dy<=99) {//���� ���ΰ�?
					if(dy-1>0 && map[dx][dy-1] == 1) {//�������� �� �� �ִٸ�
						map[dx][dy] = 0;
						dy--;
						
					}else if(dy+1<=99 && map[dx][dy+1] == 1) {//�������� �� �� �ִٸ�
						map[dx][dy] = 0;
						dy++;
						
					}else {//�� ������ ���θ� �̵�
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
