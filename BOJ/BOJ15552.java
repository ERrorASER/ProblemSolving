package com.study.algo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15552 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int result = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}