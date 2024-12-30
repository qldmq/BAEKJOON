import java.io.*;
import java.util.*;

public class Main18352 {
    static List<List<Integer>> adjList = new ArrayList<>(); // 인접 리스트
    static int N, K;

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1]; // 거리 저장 배열
        Arrays.fill(distance, -1); // 초기값 -1로 설정 (미방문 상태)
        
        queue.offer(start);
        distance[start] = 0; // 시작 도시의 거리는 0으로 초기화

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (int neighbor : adjList.get(p)) {
                if (distance[neighbor] == -1) { // 미방문 도시만 탐색
                    queue.offer(neighbor);
                    distance[neighbor] = distance[p] + 1; // 거리 갱신
                }
            }
        }

        // 거리 K인 도시 출력
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) { // 거리 K를 만족하는 도시 출력
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1); // 거리 K인 도시가 없을 경우 -1 출력
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());
            adjList.get(A).add(B); // 단방향 간선 추가
        }

        BFS(X);
    }
}
