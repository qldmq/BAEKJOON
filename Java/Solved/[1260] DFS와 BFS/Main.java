import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int v;
    static boolean Visited_ary[];
    static int ary[][];

    public static void DFS(int start) {     // dfs는 정렬보다는 stack을 사용
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
    
        while (!stack.isEmpty()) {
            int current = stack.pop();
    
            if (!Visited_ary[current]) {
                Visited_ary[current] = true;
                System.out.print(current + " ");
    
                // 인접 정점을 역순으로 스택에 추가
                for (int i = n; i >= 1; i--) {
                    if (ary[current][i] == 1 && !Visited_ary[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        Visited_ary[start] = true;
        System.out.print(start + " ");

        while (!que.isEmpty()) {
            start = que.poll();

            for (int i = 1; i <= n; i++) {
                if (ary[start][i] == 1 && !Visited_ary[i]) {
                    que.offer(i);
                    Visited_ary[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        ary = new int[1001][1001];
        Visited_ary = new boolean[1001];

        for (int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            ary[a][b] = ary[b][a] = 1;  // 정점 a와 b가 연결되어있음을 나타냄
        }

        DFS(v);
        System.out.println();

        Visited_ary = new boolean[1001];
        BFS(v);
    }
}
