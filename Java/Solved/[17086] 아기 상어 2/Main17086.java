import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17086 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, 1, 1, -1, -1, -1, 0, 0};
    static int dy[] = {0, 1, -1, 0, 1, -1, 1, -1};
    static int N, M;
    static int gurry = 0;

    public static int BFS(int x, int y) {
        visited_ary = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;
        
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for (int s = 0; s < size; s++) {
                Point p = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int xx = p.x + dx[i];
                    int yy = p.y + dy[i];

                    if (xx >= 0 && yy >= 0 && xx < N && yy < M && !visited_ary[xx][yy]) {
                        if (ary[xx][yy] == 1) {
                            return cnt;
                        }
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ary = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ary[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ary[i][j] == 0) {
                    int a = BFS(i, j);
                    gurry = Math.max(gurry, a);
                }
            }
        }

        System.out.println(gurry);
    }
}
