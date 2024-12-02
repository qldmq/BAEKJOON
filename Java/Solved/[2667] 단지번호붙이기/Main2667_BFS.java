import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667_BFS {
    static int n;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int ary[][];
    static boolean visited_ary[][];
    static ArrayList cnt = new ArrayList();
    static int sum = 0;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int local_cnt = 1;

        visited_ary[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i=0; i<4; i++) {

                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                
                if (nextX<0 || nextX>=n || nextY<0 || nextY>=n)
                    continue;
                if (ary[nextX][nextY]==0)
                    continue;
                if(visited_ary[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited_ary[nextX][nextY] = true;
                local_cnt++;
            }
        }
        cnt.add(local_cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int call_num = 0;
        n = Integer.parseInt(br.readLine());
        ary = new int[n][n];
        visited_ary = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<s.length(); j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (ary[i][j]==1 && visited_ary[i][j]==false) {
                    BFS(i, j);
                    call_num++;
                }
            }
        }

        System.out.println(call_num);

        Collections.sort(cnt);
        for (int i=0; i<cnt.size(); i++) {
            System.out.println(cnt.get(i));
            // .get(i)는 리스트의 i번째 요소를 가져옴
        }
    }
}
