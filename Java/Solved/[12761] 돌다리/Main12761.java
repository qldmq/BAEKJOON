import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12761 {

    static int[] visited;
    static int[] dist;
    static int steps;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jump1 = Integer.parseInt(st.nextToken());
        int jump2 = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        visited = new int[target + 1];
        dist = new int[100001];

        bfs(jump1, jump2, start, target, visited, dist);
    }

    private static void bfs(int jump1, int jump2, int start, int target, int[] visited, int[] dist) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        int[] moves = { 1, -1, -jump1, jump1, -jump2, jump2 };
        int[] multipliers = {jump1, jump2};
        steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int current = queue.poll();
                
                for (int i = 0; i < 6; i++) {

                    int next = current + moves[i];

                    if (next < 0 || next >= 100001) {
                        continue;
                    }

                    if (dist[next] != 0) {
                        continue;
                    }

                    if (next == target) {
                        System.out.println(steps + 1);
                        return;
                    }
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }

                for (int i = 0; i < 2; i++) {

                    int next = current * multipliers[i];

                    if (next < 0 || next >= 100001) {
                        continue;
                    }

                    if (dist[next] != 0) {
                        continue;
                    }

                    if (next == target) {
                        System.out.println(steps + 1);
                        return;
                    }
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
            steps++;
        }
    }
}
