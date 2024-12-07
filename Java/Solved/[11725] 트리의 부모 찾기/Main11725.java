import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11725 {
    static ArrayList<Integer> list[];
    static int parent[];
    static boolean visited_ary[];

    public static void DFS(int index) {
        visited_ary[index] = true;
        for (int i:list[index]) {
            if (!visited_ary[i]) {
                parent[i] = index;
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

        for (int i=0; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);     // offer은 queue에서 사용하기 때문에 list에서는 add 사용
            list[b].add(a);
        }
        
        DFS(1);

        for (int i=2; i<parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}
