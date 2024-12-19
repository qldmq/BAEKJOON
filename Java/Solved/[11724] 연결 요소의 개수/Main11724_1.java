import java.io.*;
import java.util.StringTokenizer;

public class Main11724_1 {
    static int ary[][];
    static boolean visited_ary[];
    static int n;

    public static void DFS (int start) {
        if (visited_ary[start] == true) {
            return;
        } else {
            visited_ary[start] = true;
            for (int i=1; i<=n; i++) {
                if(ary[start][i] == 1){
                    DFS(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ary = new int[n+1][n+1];
        visited_ary = new boolean[n+1];

        for (int i=0; i<m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            ary[u][v] = ary[v][u] = 1;
        }

        int count = 0;

        for (int i=1; i<=n; i++) {
            if (visited_ary[i] == false) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
