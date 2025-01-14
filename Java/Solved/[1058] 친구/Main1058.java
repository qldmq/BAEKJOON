import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1058 {
    static final int INF = 100000000;
    static boolean[][] friends = new boolean[51][51];

    public static int BFS(int student, int N) {
        boolean[] visited_ary = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        visited_ary[student] = true;
        queue.offer(student);

        for (int i = 1; i <= N; i++) {
            if (friends[student][i]) {
                visited_ary[i] = true;
                count++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (visited_ary[i]) continue;

            for (int j = 1; j <= N; j++) {
                if (friends[student][j] && friends[j][i]) {
                    visited_ary[i] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                if (str[j - 1] == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, BFS(i, N));
        }

        System.out.println(max);
    }
}
