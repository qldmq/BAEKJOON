import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012_1 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int n, m;
    static int cnt;

    public static void BFS(int start, int end) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, end));
        visited_ary[start][end] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>=0 && yy>=0 && xx<n && yy<m) {
                    if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
    
            ary = new int[n][m];
            visited_ary = new boolean[n][m];
            
            cnt = 0;

            for (int j=0; j<k; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                ary[b][a] = 1;
            }

            for (int j=0; j<n; j++) {
                for (int h=0; h<m; h++) {
                    if (ary[j][h]==1 && !visited_ary[j][h]) {
                        BFS(j, h);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }        
    }
}
