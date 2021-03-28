package com.study.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1};
	static class Virus{
		int x;
		int y;
		Virus(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n,m,max;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {//입력
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		// 벽 세우는 함수
		dfs(0);
		System.out.println(max);
	}
	
	private static void dfs(int wall) {
		if(wall == 3) {
			virus();//virus확산
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;//벽 세우기
					dfs(wall+1);
					map[i][j] = 0;//돌려놓기
				}
			}
		}
	}
	
	private static void safeArea(int[][] temp) {//0을 count해주는 함수
		int count = 0;
		for(int i=0; i<n; i++) {//입력
			for(int j=0; j<m; j++) {
				if(temp[i][j] == 0) count++;
			}
		}
		max = Math.max(max, count);
	}
	
	private static void virus() {
		Queue<Virus> queue = new LinkedList<Virus>();
		int temp[][] = new int[n][m];
		
		//map copy && virus 위치 저장
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[i][j];
				if(temp[i][j] == 2) {
					queue.offer(new Virus(i,j));
				}
			}
		}
		
		//virus 확산
		while(!queue.isEmpty()) {
			Virus current = queue.poll();
			int x = current.x;
			int y = current.y;
			
			for(int i=0; i<4; i++) {//4방향 탐색
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isValid(nx,ny) && temp[nx][ny] == 0) {//빈 공간이라면 
					temp[nx][ny] = 2;//바이러스가 확산하고
					queue.offer(new Virus(nx,ny));//BFS이므로 해당 바이러스를 queue에 넣어준다.
				}
			}	
		}
		safeArea(temp);
	}
	
	private static boolean isValid(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<m) return true;
		return false;
	}

}
