import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606_1 {
    static int ary[][];
    static boolean visited_ary[];
    static int n;
    static int cnt = 0;

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited_ary[start] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i=1; i<=n; i++) {
                if (ary[temp][i]==1 && visited_ary[i]==false) {
                    queue.offer(i);
                    visited_ary[i] = true;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        ary = new int[n+1][n+1];
        visited_ary = new boolean[n+1];

        for (int i=0; i<line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[a][b] = ary[b][a] = 1;
        }

        BFS(1);
        System.out.println(cnt);
    }
}
