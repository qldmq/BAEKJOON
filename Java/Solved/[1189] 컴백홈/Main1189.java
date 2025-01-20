import java.io.*;
import java.util.StringTokenizer;

public class Main1189 {
    static char ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int R, C, K;
    static int cnt = 0;
    
    public static void DFS(int x, int y, int local_cnt) {
        
        if (x==0 && y==C-1) {
            if (local_cnt==K) {
                cnt++;
            }
            return;
        }
        
        visited_ary[x][y] = true;
        
        for (int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx>=0 && yy>=0 && xx<R && yy<C) {
                if (ary[xx][yy]!='T' && !visited_ary[xx][yy]) {
                    visited_ary[xx][yy] = true;
                    DFS(xx, yy, local_cnt+1);
                    visited_ary[xx][yy] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ary = new char[R][C];
        visited_ary = new boolean[R][C];

        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j=0; j<C; j++) {
                ary[i][j] = s.charAt(j);
            }
        }
        
        DFS(R-1, 0, 1);

        System.out.println(cnt);
    }
}
