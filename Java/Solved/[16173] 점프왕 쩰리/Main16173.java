import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16173 {

    static int ary[][];
    static boolean[][] visited_ary;
	static int dx[] = {0, 1};
    static int dy[] = {1, 0};
    static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		ary = new int[N][N];
		visited_ary = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0);
		
		System.out.println("Hing");
	}

	private static void DFS(int i, int j) {
		if(ary[i][j] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		
		for (int k = 0; k < 2; k++) {
			int x = i + dx[k] * ary[i][j];
			int y = j + dy[k] * ary[i][j];
			if(x>=N || y>=N || visited_ary[x][y]) continue;
			
			visited_ary[x][y] = true;
			DFS(x, y);
		}
		
	}

}