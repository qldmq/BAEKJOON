import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
    static int k;
    static int visited_ary[] = new int[100001];

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited_ary[x] = 1;

        while (!queue.isEmpty()) {
            int ex = queue.poll();
            
            for (int i=0; i<3; i++) {
                int temp = 0;
                if (i == 0) {
                    temp = ex - 1;
                } else if (i == 1) {
                    temp = ex + 1;
                } else {
                    temp = ex * 2;
                }
                if (k == temp) {
                    System.out.println(visited_ary[ex]);
                    return;
                }
                if (temp >= 0 && temp < visited_ary.length && visited_ary[temp] == 0) {
                    queue.offer(temp);
                    visited_ary[temp] = visited_ary[ex] + 1;
                }
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            BFS(n);
        }
    }
}
