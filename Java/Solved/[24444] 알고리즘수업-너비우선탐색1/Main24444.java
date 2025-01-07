import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main24444 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited_ary;

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        queue.offer(x);
        visited_ary[x] = cnt++;

        while(!queue.isEmpty()){
            int a = queue.poll();

            for(int i = 0; i<graph.get(a).size(); i++){
                int next = graph.get(a).get(i);

                if(visited_ary[next] != 0)
                    continue;

                queue.offer(next);
                visited_ary[next] = cnt++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited_ary = new int[N + 1];

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

        for(int i = 1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        BFS(R);

        for(int i = 1; i<=N; i++) {
            System.out.println(visited_ary[i]);
        }
    }
}
