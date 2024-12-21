
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11725_1 {
    static ArrayList<Integer> list[];
    static int parent[];
    static boolean visited_ary[];

    public static void DFS(int x) {
        visited_ary[x] = true;
        for (int i:list[x]) {
            if (!visited_ary[i]) {
                parent[i] = x;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        parent = new int[n+1];
        visited_ary = new boolean[n+1];
        
        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }

        DFS(1);

        for (int i=2; i<=n; i++) {
            System.out.println(parent[i]);
        }
    }
}
