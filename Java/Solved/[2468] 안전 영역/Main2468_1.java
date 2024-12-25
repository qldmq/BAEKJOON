import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468_1 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int n;
    static int rain;
    static int cnt;
    static int max = 0;

    public static void BFS(int a, int b) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b));
        visited_ary[a][b] = true;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>0 && xx<=n && yy>0 && yy<=n) {
                    if (ary[xx][yy]>rain && !visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ary = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=1; j<=n; j++) {
                
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (rain=0; rain<=100; rain++) {
            cnt = 0;
            visited_ary = new boolean[n+1][n+1];
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (ary[i][j]>rain && !visited_ary[i][j]) {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }
            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}
