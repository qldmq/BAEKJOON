import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697_1 {
    static int ary[] = new int[100001];
    static int k;

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        ary[x] = 1;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (int i=0; i<3; i++) {
                int temp = 0;

                if (i == 0) {
                    temp = p + 1;
                } else if (i == 1) {
                    temp = p - 1;
                } else {
                    temp = p * 2;
                }

                if (temp==k) {
                    System.out.println(ary[p]);
                    return;
                }

                if (temp >= 0 && temp < ary.length && ary[temp] == 0) {
                    queue.offer(temp);
                    ary[temp] = ary[p] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n==k) {
            System.out.println(0);
        } else {
            BFS(n);
        }
    }
}
