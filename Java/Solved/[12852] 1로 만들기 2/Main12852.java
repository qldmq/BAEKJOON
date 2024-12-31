import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main12852 {
    static int ary[];
    static boolean visited_ary[];
    static int[] prev; // 경로 추적 배열
    static int N;

    public static void BFS () {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited_ary[N] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll();

            if (next==1) {
                return;
            }

            if (next%3 == 0) {
                if (next/3 >= 1 && !visited_ary[next/3]) {
                    ary[next/3] = ary[next] + 1;
                    prev[next / 3] = next; // 이전 상태 저장
                    queue.offer(next/3);
                    visited_ary[next/3] = true;
                }
            }

            if (next%2 == 0) {
                if (next/2 >= 1 && !visited_ary[next/2]) {
                    ary[next/2] = ary[next] + 1;
                    prev[next / 2] = next; // 이전 상태 저장
                    queue.offer(next/2);
                    visited_ary[next/2] = true;
                
                }
            }

            if (next-1 >= 1 && !visited_ary[next-1]) {
                ary[next-1] = ary[next] + 1;
                prev[next - 1] = next; // 이전 상태 저장
                queue.offer(next-1);
                visited_ary[next-1] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ary = new int[N+1];
        visited_ary = new boolean[N+1];
        prev = new int[N + 1]; // 이전 상태 저장용 배열 초기화
    
        BFS();

        System.out.println(ary[1]);

        // 경로 출력
        List<Integer> path = new ArrayList<>();
        int current = 1;

        while (current != 0) {
            path.add(current);
            current = prev[current];
        }

        // 경로를 역순으로 출력
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
