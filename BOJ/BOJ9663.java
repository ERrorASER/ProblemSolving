import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,count;
	static int[][] map;
	static boolean[][] isSelected;
	//오른 대각선, 왼 대각선,
	static int[] x = {-1,-1,1,1};
	static int[] y = {-1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[15][15];
		count = 0;

		dfs(0);
		System.out.println(count);
	}

	public static boolean isValid(int i,int cnt) {
		for(int j = 0; j < cnt; j++) {
			if(map[i][j]==1) return false;//그 행에 퀸이 있으면 안된다.
		}

		for(int j=1; j<=n; j++) {//대각선 체크
			for(int k=0; k<4; k++) {
				int dx = i+j*x[k];
				int dy = cnt + j*y[k];
				//System.out.println("i: "+i+" cnt: "+cnt+" dx:"+dx+" dy:"+dy);
				if(dx>=0 && dy>=0 && dx<n && dy<n) {
					if(map[dx][dy]==1) return false;
				}
			}
		}
		

		return true;
	}

	public static void dfs(int cnt) {
		if(cnt == n) {
			count++;
			return;
		}

		for(int i=0; i<n; i++) {
			if(map[i][cnt] == 0 && isValid(i,cnt)) {//비어있고 놓을 수 있냐?
				map[i][cnt] = 1;
				dfs(cnt+1);
				map[i][cnt] = 0;
			}
		}

	}

}
