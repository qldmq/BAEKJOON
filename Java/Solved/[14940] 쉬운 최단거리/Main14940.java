import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14940 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;

    public static void BFS (int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                
                if (xx>=0 && yy>=0 && xx<N && yy<M) {
                    if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        ary[xx][yy] = ary[p.x][p.y] + 1;
                        visited_ary[xx][yy] = true;
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

        ary = new int[N][M];
        visited_ary = new boolean[N][M];

        for (int i=0; i<N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                ary[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (ary[i][j]==2 && !visited_ary[i][j]) {
                    ary[i][j] = 0;
                    BFS(i, j);
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (ary[i][j]==1 && !visited_ary[i][j]) {
                    ary[i][j] = -1;
                }
            }
        }
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++ ){
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }
}
