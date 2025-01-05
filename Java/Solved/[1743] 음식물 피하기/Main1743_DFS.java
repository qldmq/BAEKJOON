import java.io.*;
import java.util.StringTokenizer;

public class Main1743_DFS {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int cnt=0;

    public static void DFS(int x, int y) {
        visited_ary[x][y] = true;
        cnt++;
        for (int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx>0 && yy>0 && xx<=N && yy<=M) {
                if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                    DFS(xx, yy);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ary = new int[N+1][M+1];
        visited_ary = new boolean[N+1][M+1];

        for (int i=0; i<K; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());
            ary[r][c] = 1;
        }

        int x = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (ary[i][j]==1 && !visited_ary[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    x = Math.max(x, cnt);
                }
            }
        }
        
        System.out.println(x);
    }
}
