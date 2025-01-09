import java.io.*;
import java.util.*;

public class Main11060 {
    static int N, ary[], cnt[];
    static boolean visited_ary[];

    static void BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited_ary[start] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == (N - 1)) {
                System.out.println(p[1]);
                return;
            }
            for (int i = 1; i <= ary[p[0]]; i++) {
                int next = p[0] + i;
                if (0 <= next && next < N && !visited_ary[next]) {
                    queue.add(new int[]{next, p[1] + 1});
                    visited_ary[next] = true;
                }
            }
        }
        System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        visited_ary = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        BFS(0);
    }
}
