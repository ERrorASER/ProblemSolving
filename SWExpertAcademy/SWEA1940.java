package com.study.classAlgo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA1940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<=tc; t++) {
			int input = Integer.parseInt(br.readLine());
			int speed = 0;
			int distance = 0;
			
			for(int k = 0; k<input; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken());
				if(type == 0) {//유지
					distance += speed;
				}else{
					int s = Integer.parseInt(st.nextToken());//추가할 속도
					if(type == 1) {//가속
						speed += s;
						distance += speed;
					}else {//감속
						speed -= s;
						if(speed<0) speed = 0;
						distance += speed;
					}
				}				
			}
			sb.append("#"+t+" "+distance+"\n");
		}
		System.out.println(sb);
	}
}