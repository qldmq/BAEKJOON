import java.io.*;
import java.util.StringTokenizer;

public class Main10451 {
    static int ary[];
    static boolean visited_ary[];
    static int cnt;

    public static void DFS(int start) {
        int a = ary[start];
        visited_ary[start] = true;

        if (!visited_ary[a]) {
            DFS(a);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=1; i<=t; i++) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            ary = new int[N+1];
            visited_ary = new boolean[N+1];

            for (int j=1; j<=N; j++) {
                ary[j] = Integer.parseInt(st.nextToken());
            }
            
            for (int k=1; k<=N; k++) {
                if (!visited_ary[k]) {
                    DFS(k);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
