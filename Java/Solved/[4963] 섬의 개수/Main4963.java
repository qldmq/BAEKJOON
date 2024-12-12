import java.io.*;
import java.util.StringTokenizer;

public class Main4963 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
    static int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
    static int w;
    static int h;

    public static void DFS(int x, int y) {
        visited_ary[x][y] = true;

        for (int i=0; i<8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx>=0 && yy>=0 && xx<h && yy<w) {
                if (ary[xx][yy]==1 && !visited_ary[xx][yy]) {
                    DFS(xx, yy);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0) {
                break;
            }

            ary = new int[h][w];
            visited_ary = new boolean[h][w];
            int cnt=0;

            for (int i=0; i<h; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    ary[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (ary[i][j]==1 && !visited_ary[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
        
            System.out.println(cnt);
        }


    }
}
