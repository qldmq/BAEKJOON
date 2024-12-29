import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {
    static int ary[];
    static boolean visited_ary[];
    static int F, S, G, U, D;

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited_ary[start] = true;
        ary[start] = 0;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            if (p == G) {
                System.out.println(ary[p]);
                return;
            }

            if (p+U <= F && !visited_ary[p+U]) {
                int up = p + U;
                visited_ary[up] = true;
                queue.offer(up);
                ary[up] = ary[p] + 1;
            }
            
            if (p-D > 0 && !visited_ary[p-D]) {
                int down = p - D;
                visited_ary[down] = true;
                queue.offer(down);
                ary[down] = ary[p] + 1;
            }
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ary = new int[F+1];
        visited_ary = new boolean[F+1];

        BFS(S);
    }
}
