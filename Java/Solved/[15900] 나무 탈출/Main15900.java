import java.io.*;
import java.util.*;

public class Main15900 {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean visited_ary[];
    static int totalDepth = 0;

    public static void DFS(int node, int depth) {
        visited_ary[node] = true;
        boolean isLeaf = true;
        
        for (int next : tree[node]) {
            if (!visited_ary[next]) {
                isLeaf = false;
                DFS(next, depth + 1);
            }
        }
        
        if (isLeaf) {
            totalDepth += depth;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited_ary = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            tree[u].add(v);
            tree[v].add(u);
        }

        DFS(1, 0);

        System.out.println(totalDepth % 2 == 1 ? "Yes" : "No");
    }
}
