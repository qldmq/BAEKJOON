import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1926 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int n, m;

    public static int BFS(int x, int y) {
        int local_cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (!visited_ary[xx][yy] && ary[xx][yy] == 1) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                        local_cnt++;
                    }
                }
            }
        }

        return local_cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visited_ary = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int cnt = 0;
        int max_size = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited_ary[i][j] && ary[i][j] == 1) {
                    int local_cnt = BFS(i, j);
                    cnt++;
                    max_size = Math.max(max_size, local_cnt);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max_size);
    }
}
