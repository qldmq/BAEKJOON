import java.io.*;
import java.util.StringTokenizer;

public class Main1388 {
    static char ary[][];
    static boolean visited_ary[][];
    static int N, M;
    static int cnt = 0;

    public static void DFS(int x, int y) { 
        visited_ary[x][y] = true;

        char c = ary[x][y];

        if (c == '-') {
            for (int i=y+1; i<M; i++) {
                if (ary[x][y] == ary[x][i]) {
                    if (!visited_ary[x][i]) {
                        DFS(x, i);
                    }
                } else {
                    break;
                }
            }
        }

        if (c == '|') {
            for (int i=x+1; i<N; i++) {
                if (ary[x][y] == ary[i][y]) {
                    if (!visited_ary[i][y]) {
                        DFS(i, y);
                    }
                } else {
                    break;
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
                if (!visited_ary[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
