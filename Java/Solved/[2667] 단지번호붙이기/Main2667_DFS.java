import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main2667_DFS {

    static int n;
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static ArrayList cnt = new ArrayList();
    static int local_cnt;

    public static void DFS (int x, int y) {
        visited_ary[x][y] = true;

        Point current = new Point(x,y);
        
        for (int i=0; i<4; i++) {
            int xx = current.x + dx[i];
            int yy = current.y + dy[i];

            if (xx>=0 && yy>=0 && xx<n && yy<n && !visited_ary[xx][yy] && ary[xx][yy]==1) {
                local_cnt++;
                DFS(xx,yy);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ary = new int[n][n];
        visited_ary = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (ary[i][j]==1 && !visited_ary[i][j]) {
                    local_cnt = 1; // DFS 호출 전에 초기화
                    DFS(i, j);
                    cnt.add(local_cnt);
                }
            }
        }

        Collections.sort(cnt);

        System.out.println(cnt.size());

        for (int i=0; i<cnt.size(); i++) {
            System.out.println(cnt.get(i));
            // .get(i)는 리스트의 i번째 요소를 가져옴
        }
    }
}
