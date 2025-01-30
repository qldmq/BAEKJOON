import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main6118 {
    static ArrayList<Integer> list[];
    static boolean visited_ary[];
    static int[] dist;

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited_ary[start] = true;
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (int i = 0; i < list[p].size(); i++) {
                int next = list[p].get(i);
                if (!visited_ary[next]) {
                    queue.offer(next);
                    visited_ary[next] = true;
                    dist[next] = dist[p] + 1;  // 현재 노드 거리 + 1
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited_ary = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i=0; i<M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i=1; i<N; i++) {
            Collections.sort(list[i]);
        }

        BFS(1);

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        int minNode = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) {
                minNode = Math.min(minNode, i);
                count++;
            }
        }

        System.out.println(minNode + " " + maxDist + " " + count);
    }
}
