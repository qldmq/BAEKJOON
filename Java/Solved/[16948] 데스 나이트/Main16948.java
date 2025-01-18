import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16948 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {-2, -2, 0, 0, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -1, 1};
    static int N;
    
    public static void BFS(int startx, int starty, int endx, int endy) {
        Queue<Point> queue = new LinkedList<>();
        visited_ary[startx][starty] = true;
        queue.offer(new Point(startx, starty));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x==endx && p.y == endy) {
                System.out.println(ary[endx][endy]);
                return;
            }

            for (int i=0; i<6; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>=0 && yy>=0 && xx<N && yy<N) {
                    if (!visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        ary[xx][yy] = ary[p.x][p.y] + 1;
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
        System.out.println(-1);
        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        ary = new int[N][N];
        visited_ary = new boolean[N][N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        BFS(r1, c1, r2, c2);
    }    
}
