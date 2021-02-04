package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		stack.push(Integer.parseInt(st.nextToken()));//Ã¹¹ø¤Š
		index.push(1);
		System.out.print("0 ");
		
		for(int i=1; i<n; i++) {
			int num =Integer.parseInt(st.nextToken());
			//stack.push(n);
			
			while(true) {
				if(!stack.isEmpty()) {
					if(stack.peek() <= num) {
						stack.pop();
						index.pop();
					}else {
						System.out.print(index.peek()+" ");
						stack.push(num);
						index.push(i+1);
						break;
					}
				}else {
					System.out.print("0 ");
					stack.push(num);
					index.push(i+1);
					break;
				}
			}
		}
	}
}