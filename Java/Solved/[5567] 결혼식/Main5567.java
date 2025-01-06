import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5567 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited_ary[];

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited_ary[x] = true;

        int level = 0; // BFS 레벨(깊이)
        
        while(!queue.isEmpty() && level < 2) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                int p = queue.poll();
                for (int j : graph.get(p)) {
                    if (!visited_ary[j]) {
                        queue.offer(j);
                        visited_ary[j] = true;
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited_ary = new boolean[n + 1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        BFS(1);

        int cnt = 0;
        for (int i = 2; i <= n; i++) { // 상근이를 제외하고 세기
            if (visited_ary[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
