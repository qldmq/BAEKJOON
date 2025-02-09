import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11723 {
    static int M, N;
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited_ary[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cx = node[0], cy = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (ary[nx][ny] == 0) continue;
                if (visited_ary[nx][ny]) continue;

                visited_ary[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            ary = new int[M][N];
            visited_ary = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (line.charAt(j) == '#') {
                        ary[i][j] = 1;
                    } else {
                        ary[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (ary[i][j] == 1 && !visited_ary[i][j]) {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
