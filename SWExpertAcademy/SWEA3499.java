package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> cards = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String[] card1 = new String[n/2+1];
			String[] card2 = new String[n/2+1];

			for(int i=0; i<Math.round((double)n / 2.0); i++) {
				card1[i] = st.nextToken();
			}
			for(int i=0; i<n/2; i++) {
				card2[i] = st.nextToken();
			}
			for(int i=0; i<n/2; i++) {
				cards.add(card1[i]);
				cards.add(card2[i]);
			}
			if(n%2 !=0) {
				cards.add(card1[n/2]);
			}
			System.out.println("#"+t+" "+cards.toString().replace("[", "").replace(",", "").replace("]", ""));
		}
		
	}

}
