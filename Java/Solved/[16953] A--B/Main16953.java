import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16953 {
    static int cnt = 1;

    public static int BFS(long start, long end) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 노드 개수

            for (int i = 0; i < size; i++) {
                long current = queue.poll();
            
                if (current == end) {
                    return cnt;
                }
                if (current * 2 <= end) {
                    queue.offer(current*2);
                }
                if (current * 10 + 1 <= end) {
                    queue.offer(current*10+1);
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        // a와 b의 제약조건이 없으므로 아주 큰 숫자일 수 있기 때문에 범위가 더 큰 long을 사용해야함
    
        System.out.println(BFS(a, b));
    }
}
