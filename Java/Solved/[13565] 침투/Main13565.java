import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main13565 {

    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean check;
    static int N, M;

    public static void BFS(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 마지막 행(M-1)에 도달하면 성공
            if (p.x == M - 1) {
                check = true;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < M && yy < N) {
                    if (ary[xx][yy] == 0 && !visited_ary[xx][yy]) {
                        visited_ary[xx][yy] = true;
                        queue.offer(new Point(xx, yy));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ary = new int[M][N];
        visited_ary = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            if (ary[0][i] == 0) {
                BFS(0, i);
            }
        }

        System.out.println(check ? "YES" : "NO");
    }
}