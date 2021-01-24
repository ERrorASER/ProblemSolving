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
			
			int[][] pond = new int[n][n];//�ȶ��ڸ��� 0, ���ڸ��� 1
			
			for(int j=0; j<bugs; j++) {
				int dx = sc.nextInt();
				int dy = sc.nextInt();
				int d = sc.nextInt();
				
				//������ġ�� �̹� �پ��� �ڸ�(1)�̸�  ��ȣ ��� �ƴϸ�(0) ����
				if(pond[dx][dy] == 0) {
					for(int jump = 3; jump>0; jump--) {
						dx += jump*x[d];
						dy += jump*y[d];
						
						//�� ��ġ�� ���� ���̸� ���߰�, �ƴ϶�� ��� ����
						if(dx>=0 && dx <n && dy>=0 && dy<n) {//���� ��
							//�� ��Ұ� �̹� �پ��� �ڸ��ΰ�? �׷��� ��� �� ����, �ƴ϶�� �ڸ� ���� �� ���
							if(pond[dx][dy] == 0) {
								pond[dx][dy] = 1;
							}else {//�پ��� �ڸ�
								System.out.println("#"+(i+1)+" " + (j+1));
								flag = true;
								break;
							}
						}else {//���� ��
							break;
						}						
					}//�ұ����̵� 3���� �ٱ�		
				}else {
					System.out.println("#"+(i+1)+" " + (j+1));
					flag = true;
					break;
				}
								
			}//�ұ����̵� 
			if(!flag) {
				System.out.println("#"+(i+1)+" 0");
			}
		}//�׽�Ʈ ���̽�
		sc.close();
	}
}