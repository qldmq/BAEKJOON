import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main24479 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int visited_ary[];
    static int cnt;

    public static void DFS(int start) {
        visited_ary[start] = cnt;
        
        for (int i = 0; i < graph.get(start).size(); i++) {
            int a = graph.get(start).get(i);
            if (visited_ary[a]==0) {
                cnt++;
                DFS(a);
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

        for (int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        DFS(R);

        for (int i = 1; i < visited_ary.length; i++) {
            System.out.println(visited_ary[i]);
        }
    }
}
