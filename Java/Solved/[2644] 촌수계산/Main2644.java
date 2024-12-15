import java.io.*;
import java.util.StringTokenizer;

public class Main2644 {
    static int ary[][];
    static boolean visited_ary[];
    static int n;
    static int parent;
    static int child;
    static int answer = -1;

    public static void DFS(int start, int end, int cnt) {
        if (start == end) {
            answer = cnt;
            return;
        }

        visited_ary[start] = true;

        for (int i=1; i<=n; i++) {
            if (ary[start][i]==1 && !visited_ary[i]) {
                DFS(i, end, cnt+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parent = Integer.parseInt(st.nextToken());
        child = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        ary = new int[n+1][n+1];
        visited_ary = new boolean[n+1];

        for (int i=0; i<m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            ary[x][y] = ary[y][x] = 1;
        }

        DFS(parent, child, 0);

        System.out.println(answer);
    }
}
