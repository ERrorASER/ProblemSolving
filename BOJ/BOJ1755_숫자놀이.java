package com.study.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1755_숫자놀이 {

	static class Num {//숫자와 알파벳을 매핑하기 위해 Num이라는 class를 만들어줬다.
		int number;//숫자 저장
		String alphabet;//숫자를 알파벳으로 변환한 값

		Num(int number, String alphabet){//생성자
			this.number = number;
			this.alphabet = alphabet;
		}

		public String getAlphabet() {//getter
			return alphabet;
		}

		public void setAlphabet(String alphabet) {//setter
			this.alphabet = alphabet;
		}

	}

	static int n,m,len;
	static Num[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//처음 시작 숫자
		m = Integer.parseInt(st.nextToken());//끝나는 숫자
		len = m-n+1;//배열의 길이
		numbers = new Num[len];//수들을 담을 배열

		int temp = n;
		for(int i=0; i<len; i++) {//n부터 m까지의 모든 숫자를 numbers에 넣어준다.
			String s = getString(temp);//숫자(int)를 알파벳(String)으로 바꿔준다. 80 -> eight zero
			numbers[i] = new Num(temp,s);//숫자와 알파벳을 매핑하여 numbers에 넣어준다.
			temp++;
		}
		Arrays.sort(numbers, new Comparator<Num>() {//알파벳 순서대로 sort해준다.
			@Override
			public int compare(Num o1, Num o2) {
				return o1.getAlphabet().compareTo(o2.getAlphabet());
			}
		});

		int idx = 1;
		for(int i=0; i<len; i++) {//알맞게 sort한 배열을 출력해주는 함수이다.
			System.out.print(numbers[i].number+" ");
			if(idx++%10==0) System.out.println();//한줄에 10개가 찍히면 줄바꿈을 해준다.
		}
	}

	static public String getString(int number) {//숫자의 크기에 따라 나누어 getChar을 호출한다.
		int ten, one;
		String result;
		if(number>=10) {//숫자가 10보다 크거나 같으면 일의 자리 숫자와 십의 자리 숫자로 나눠준다.
			ten = number/10;//십의자리 숫자
			one = number%10;//일의자리 숫자
			result = getChar(ten)+getChar(one);//숫자들을 합해준다.
		}else {//숫자가 일의자리 숫자면 따로 나눠줄 필요없이 일의자리 숫자만 sting으로 바꿔준다.
			one = number;
			result = getChar(one);
		}
		return result;//결과 반환
	}
	static public String getChar(int number) {//일의 자리 숫자를 알맞은 string으로 바꿔준다. 1->one
		if(number == 1) return "one";
		else if(number == 2) return "two";
		else if(number == 3) return "three";
		else if(number == 4) return "four";
		else if(number == 5) return "five";
		else if(number == 6) return "six";
		else if(number == 7) return "seven";
		else if(number == 8) return "eight";
		else if(number == 9) return "nine";
		else return "zero";
	}
}
