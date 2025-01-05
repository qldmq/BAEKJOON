import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1743_BFS {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int cnt;
    
    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;
        cnt++;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>0 && yy>0 && xx<=N && yy<=M) {
                    if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                        cnt++;
                    }
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

        for (int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ary[r][c] = 1;
        }

        int x = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (ary[i][j]==1 && !visited_ary[i][j]) {
                    cnt = 0;
                    BFS(i, j);
                    x = Math.max(cnt, x);
                }
            }
        }

        System.out.println(x);
    }
}
