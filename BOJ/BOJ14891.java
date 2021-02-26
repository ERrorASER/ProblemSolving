package day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int[][] map,status;
	static int k;
	public static void main(String[] args) throws IOException {
		//1. ��Ϲ��� ���� �Է�
		//2. ȸ�� Ƚ���� ��� �Է�
		//3. (1������� 2, 2�� ����� 6), (2������� 2, 3�� ����� 6), (3������� 2, 4�� ����� 6)
		//3-1. ���ؼ� ���� ���ٸ� �ݴ� �������� ��ϸ� ������
		//3-2. ���ؼ� ���� �ٸ��ٸ� �״�� �ΰ�
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][8];
		
		//1. ��Ϲ��� ���� �Է�
		for(int i=0; i<4; i++) {
			String temp = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = temp.charAt(j) -'0';
			}
		}
		//2. ȸ�� Ƚ���� ��� �Է�
		k = Integer.parseInt(br.readLine());
		status = new int[k][2];
		int num;
		int s;
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			leftRotation(num-1, s);
			rightRotation(num-1,s);
			if(s==1) clockwise(num-1);
			else counterClockwise(num-1);
		}
		
		int p = 0;
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(map[i][0] == 1) {
				sum+= Math.pow(2, p);
			}
			p++;
		}
		System.out.println(sum);
		
		
	}
	
	private static void rightRotation(int i, int s) {
		int right = i+1;//������ ���
		
		if(right<4) {
			if(map[right][6] == map[i][2]) {//���ٸ� ȸ�� X
				return;
			}else if(map[right][6] != map[i][2]) {//���� �ʴٸ�
				rightRotation(right,-s);
				if(s == 1) {
					counterClockwise(right);
				}else {
					clockwise(right);
				}
			}
		}		
	}

	private static void leftRotation(int i, int s) {
		int left = i-1;//���� ���
		
		if(left>=0) {//���� ����
			if(map[left][2] == map[i][6]) {//���ٸ� ȸ�� X
				return;
			}else if(map[left][2] != map[i][6]) {//���� �ʴٸ�
				leftRotation(left, -s);
				if(s == 1) {
					counterClockwise(left);
				}else {
					clockwise(left);
				}
			}
		}
	}

	//�ð�������� ȸ��
	static void clockwise(int num) {//num�� ȸ����Ű�� ��Ϲ��� ��ȣ
		int lastNum = map[num][7];
		
		for(int i=7; i>0; i--) {
			map[num][i] = map[num][i-1];
		}
		map[num][0] = lastNum;
	}
	
	//�ݽð�������� ȸ��
	static void counterClockwise(int num) {//num�� ȸ����Ű�� ��Ϲ��� ��ȣ
		int firstNum = map[num][0];
		
		for(int i=0; i<7; i++) {
			map[num][i] = map[num][i+1];
		}
		map[num][7] = firstNum;
	}

}
