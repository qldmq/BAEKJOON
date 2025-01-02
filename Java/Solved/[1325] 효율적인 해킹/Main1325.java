import java.io.*;
import java.util.*;

public class Main1325 {
    static ArrayList<Integer>[] ary;
    static boolean[] visited_ary;
    static int[] cnt;
    static int max;

    public static void BFS(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited_ary[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : ary[current]) {
                if (!visited_ary[next]) {
                    visited_ary[next] = true;
                    cnt[next]++;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ary = new ArrayList[N + 1];
        cnt = new int[N + 1];
        max = 0;

        for (int i = 1; i <= N; i++) {
            ary[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            ary[A].add(B);
        }

        for (int i = 1; i <= N; i++) {
            visited_ary = new boolean[N + 1];
            BFS(i);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, cnt[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
