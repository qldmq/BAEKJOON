import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178_1 {
    static int n, m;
    static int ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean visited_ary[][];

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));

        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i=0; i<4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m)
                    continue;
                if (ary[nextX][nextY] == 0)
                    continue;
                if (visited_ary[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited_ary[nextX][nextY] = true;

                ary[nextX][nextY] = ary[current.x][current.y] + 1;
            }
        }
        System.out.println(ary[n-1][m-1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visited_ary = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<s.length(); j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }

        BFS(0, 0);
    }
}
