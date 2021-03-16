package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int l,c;
	static char[] numbers,results;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());//4
		c = Integer.parseInt(st.nextToken());//6
		numbers = new char[c];
		results = new char[l];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			numbers[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(numbers);
		
		combination(0,0);
		
	}
	private static void combination(int cnt, int start) {
		if(cnt == l) {
			int vowels = 0;
			int consonants = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<l; i++) {
				if(results[i] == 'a' || results[i] == 'e'|| results[i] == 'i'|| results[i] == 'o'|| results[i] == 'u') {
					vowels++;
				}else {
					consonants++;
				}
			}
			
			if(vowels>0 && consonants>1) {
				for(int i=0; i<l; i++) {
					sb.append(results[i]);
				}
				System.out.println(sb);
			}
			return;
		}
		
		for(int i= start; i<c; i++) {
			results[cnt] = numbers[i];
			combination(cnt+1,i+1);
		}
	}

}
