import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main24445 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited_ary[];
    static int N;

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited_ary[start] = true;

        int cnt = 0;
        int count[] = new int[N+1];

        while (!queue.isEmpty()) {
            int p = queue.poll();
            count[p] = ++cnt;

            for (int i=0; i<graph.get(p).size(); i++) {
                int next = graph.get(p).get(i);
                if (!visited_ary[next]) {
                    visited_ary[next] = true;
                    queue.offer(next);
                }
            }
        }

        for (int i=1; i<=N; i++) {
            System.out.println(count[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited_ary = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i=0; i<graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        BFS(R);

        
    }    
}
