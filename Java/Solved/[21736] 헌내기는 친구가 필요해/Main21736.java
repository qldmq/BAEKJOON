import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main21736 {
    static char ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int cnt=0;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>=0 && yy>=0 && xx<N && yy<M) {
                    if (ary[xx][yy]=='O' && !visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                    if (ary[xx][yy]=='P' && !visited_ary[xx][yy]) {
                        cnt++;
                        queue.offer(new Point(xx, yy));
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
        
        ary = new char[N][M];
        visited_ary = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                ary[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (ary[i][j]=='I') {
                    BFS(i, j);
                }
            }
        }

        if (cnt==0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }    
}
