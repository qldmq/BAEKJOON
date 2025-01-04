import java.io.*;
import java.util.StringTokenizer;

public class Main1303 {
    static char ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int N, M;
    static int local_cnt;

    public static int DFS(int x, int y, char color) {
        visited_ary[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < M && yy < N) {
                if (ary[xx][yy] == color && !visited_ary[xx][yy]) {
                    cnt += DFS(xx, yy, color);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ary = new char[M][N];
        visited_ary = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                ary[i][j] = s.charAt(j);
            }
        }

        int white = 0;
        int blue = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited_ary[i][j]) {
                    char color = ary[i][j];
                    int cnt = DFS(i, j, color);
                    if (color == 'W') {
                        white += cnt*cnt;
                    } else {
                        blue += cnt*cnt;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }
}
