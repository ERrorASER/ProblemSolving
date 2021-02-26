package day0226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17829 {
	static int n;
	static int[][] map,result;
	static Queue<Integer> temp;
	public static void main(String[] args) throws Exception {
		//1. �Է¹ޱ�
		//2. 2*2�� ������
		//3. 2*2�� ���� ��Ŀ��� �ι�° �� ã��
		//4. �� �ֱ�
		//5. 1*1�� �ƴϸ� 2������ ���ư��� ��� �ݺ��ϱ�
		
		//1. �Է¹ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		temp = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			//2. 2*2�� ������
			for(int i=0; i<n; i+=2) {//0,2,4,6,8
				int[] subMatrix = new int[4];
				
				for(int j=0; j<n; j+=2) {//0,2,4,6,8
					int idx = 0;
					subMatrix[idx++] = map[i][j];
					subMatrix[idx++] = map[i][j+1];
					subMatrix[idx++] = map[i+1][j];
					subMatrix[idx++] = map[i+1][j+1];
					//3. 2*2�� ���� ��Ŀ��� �ι�° �� ã��
					Arrays.sort(subMatrix);
					temp.add(subMatrix[2]);
				}
			}
						
			map = new int[n/2][n/2];
			//4. �� �ֱ�
			for(int j=0; j<n/2; j++) {
				for(int i=0; i<n/2; i++) {
					map[j][i] = temp.poll();
				}
			}
			//5. 1*1�� �ƴϸ� 2������ ���ư��� ��� �ݺ��ϱ�
			n /= 2;
			if(map.length == 1) break;
		}
		System.out.println(map[0][0]);

	}

}
