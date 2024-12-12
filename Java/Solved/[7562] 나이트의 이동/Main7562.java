// 문제가 최소를 구하는것이기 때문에 BFS를 사용해야함
import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
    static int dy[] = {1, -1, 1, -1, 2, -2, 2, -2};
    static int l;
    static int rsx;
    static int rsy;

    public static void BFS (int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int i=0; i<8; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx>=0 && yy>=0 && xx<l && yy<l) {
                    if (!visited_ary[xx][yy]) {
                        visited_ary[x][y] = true;
                        ary[xx][yy] = ary[xx][yy] + 1;
                        queue.offer(new Point(xx, yy));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            for (int j=0; j<3; j++) {
                l = Integer.parseInt(br.readLine());

                ary = new int[l][l];
                visited_ary = new boolean[l][l];

                StringTokenizer st = new StringTokenizer(br.readLine());
                int nowx = Integer.parseInt(st.nextToken());
                int nowy = Integer.parseInt(st.nextToken());
                StringTokenizer str = new StringTokenizer(br.readLine());
                rsx = Integer.parseInt(str.nextToken());
                rsy = Integer.parseInt(str.nextToken());

                BFS(nowx, nowy);
            }
        }
    }
}
