import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {
    static int m;
    static int n;
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int cnt[];
    static int local_cnt;

    public static void BFS (int a, int b) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b));
        visited_ary[a][b] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i=0; i<4; i++) {
                int xx = current.x + dx[i];
                int yy = current.y + dy[i];

                if (xx<0 || yy<0 || xx>=m || yy>=n || ary[xx][yy]!=1 || visited_ary[xx][yy]==true) {
                    continue;
                }
                queue.offer(new Point(xx, yy));
                visited_ary[xx][yy] = true;
            }
        }

        local_cnt++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        cnt = new int[t];
        
        for (int i=0; i<t; i++) {
            local_cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ary = new int[m][n];
            visited_ary = new boolean[m][n];

            for (int j=0; j<k; j++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());
                ary[x][y] = 1;
            }

            for (int a=0; a<m; a++) {
                for (int b=0; b<n; b++) {
                    if (ary[a][b]==1 && visited_ary[a][b]==false) {
                        BFS(a, b);
                    }
                }
            }
            
            cnt[i] = local_cnt;
        }

        for (int i=0; i<t; i++) {
            System.out.println(cnt[i]);
        }
        
    }
}
