import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main2667_1 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int n;
    static int cnt=0;
    static ArrayList<Integer> local_cnt = new ArrayList();
    static int lc;

    public static void DFS(int x, int y) {
        visited_ary[x][y] = true;

        for (int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx>=0 && yy>=0 && xx<n && yy<n) {
                if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                    lc++;
                    DFS(xx, yy);
                }
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

            for (int j=0; j<s.length(); j++) {
                ary[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (ary[i][j]==1 && !visited_ary[i][j]) {
                    lc = 1;
                    DFS(i, j);
                    local_cnt.add(lc);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(local_cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(local_cnt.get(i));
            // .get(i)는 리스트의 i번째 요소를 가져옴
        }
    }
}
