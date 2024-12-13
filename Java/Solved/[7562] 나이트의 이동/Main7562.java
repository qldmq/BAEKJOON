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

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int nx = p.x;
            int ny = p.y;

            for (int i=0; i<8; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];

                if (xx==rsx && yy==rsy) {
                    ary[xx][yy] = ary[nx][ny] + 1;
                    return;
                }

                if (xx>=0 && yy>=0 && xx<l && yy<l) {
                    if (!visited_ary[xx][yy]) {
                        ary[xx][yy] = ary[nx][ny] + 1;
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
            l = Integer.parseInt(br.readLine());

            ary = new int[l][l];
            visited_ary = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowx = Integer.parseInt(st.nextToken());
            int nowy = Integer.parseInt(st.nextToken());
            StringTokenizer str = new StringTokenizer(br.readLine());
            rsx = Integer.parseInt(str.nextToken());
            rsy = Integer.parseInt(str.nextToken());

            if (nowx==rsx && nowy==rsy) {
                System.out.println(0);
            } else {
                BFS(nowx, nowy);
                System.out.println(ary[rsx][rsy]);
            }
        }
    }
}
