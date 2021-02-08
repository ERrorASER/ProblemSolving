package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			int[][] numbers = new int[9][9];
			int[] isSelected;
			boolean flag = false;

			for(int i=0; i<9; i++) {//½ºµµÄí ÀÔ·Â¹Þ±â
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<9; i++) {//°¡·Î Å½»ö
				isSelected = new int[9];
				for(int j=0; j<9; j++) {
					isSelected[numbers[i][j]-1]=1;//°¡·Î Å½»ö
				}
				for(int z=0; z<9; z++) {
					if(isSelected[z] == 0) {
						flag = true;
						break;
					}
				}
			}

			//¼¼·Î Å½»ö
			for(int i=0; i<9; i++) {
				isSelected = new int[9];
				for(int j=0; j<9; j++) {
					isSelected[numbers[j][i]-1]=1;//¼¼·Î Å½»ö
				}
				for(int z=0; z<9; z++) {
					if(isSelected[z] == 0) {
						flag = true;
						break;
					}
				}
			}

			//3x3Ã¼Å©
			isSelected = new int[9];
			for(int i = 0; i<=6; i+=3) {

				for(int j=0; j<=6; j+=3) {
					isSelected = new int[9];
					for(int x = i; x<i+3; x++) {
						for(int y = j; y<j+3; y++) {
							isSelected[numbers[x][y]-1]=1;
						}
					}
				}
				for(int z=0; z<9; z++) {

					if(isSelected[z] == 0) {
						flag = true;
						break;
					}
				}
			}

			if(flag)
				System.out.println("#"+t+" "+0);
			else
				System.out.println("#"+t+" "+1);

		}
	}
}