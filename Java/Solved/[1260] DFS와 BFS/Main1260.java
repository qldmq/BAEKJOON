// DFS란 깊이 우선 탐색
// BFS란 너비 우선 탐색

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {
    // main 메서드는 static으로 선언되어 있음
    // static으로 선언하지 않고 int를 선언할 경우 객체를 생성해야 하는데 main 메서드는 객체를 생성하지 않기 때문에 static으로 선언해주어야 함
    static int n;
    static int m;
    static int v;
    static boolean Visited_ary[];
    static int count;
    static int ary[][];
    static Queue<Integer> que = new LinkedList<>();


    public static void DFS (int start) {
        Visited_ary[start] = true;
        System.out.print(start + " ");
        
        if (count == n) {
            return;
        }
        count++;

        for (int i=1; i<=n; i++) {
            if (ary[start][i] == 1 && Visited_ary[i] == false) {
                DFS(i);
            }
        }
    }

    public static void BFS (int start) {
        que.offer(start);
        // .offer()는 큐 자료구조에서 사용하는 메소드로 start값을 큐의 끝에 추가하는 것
        Visited_ary[start] = true;
        System.out.print(start + " ");

        while (!que.isEmpty()) {
            start = que.poll();     // 큐의 가장 앞에 있는 정점을 꺼냄
            // .poll()은 큐에서 데이터를 꺼내는 메서드, FIFO 방식으로 동작

            for (int i=1; i<=n; i++) {
                if (ary[start][i] == 1 && Visited_ary[i] ==false) {
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

        // 그래프 탐색에서 필수적인 초기화 작업
        ary = new int[1001][1001];
		Visited_ary = new boolean[1001];
        
        for (int i=0; i<m; i++) {
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
