import java.io.*;
import java.util.StringTokenizer;

public class Main1388 {
    static char ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int cnt = 0;

    public static void DFS(int x, int y, char c) { 
        visited_ary[x][y] = true;

        for (int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx>=0 && yy>=0 && xx<N && yy<M) {
                if (!visited_ary[xx][yy]) {

                    System.out.println("DFS 실행");
                    char dd = ary[xx][yy];
                    if (c==dd) {
                        DFS(xx, yy, dd);
                        System.out.println(dd);
                    } else {
                        cnt++;
                        System.out.println("증가");
                    }
                    visited_ary[xx][yy] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ary = new char[N][M];
        visited_ary = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<M; j++) {
                ary[i][j] = s.charAt(j);    
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                char c = ary[i][j];
                DFS(i, j, c);
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }

        System.out.println(cnt);
    }
}
