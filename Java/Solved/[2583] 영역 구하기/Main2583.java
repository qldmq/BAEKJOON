import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2583 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int m, n;
    static int x1, x2, y1, y2;
    static int cnt = 0;
    static int area[];

    public static void BFS (int x, int y) {
        int local_area = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;
        cnt++;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            local_area++;
            
            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];

                if (xx>=0 && yy>=0 && xx<m && yy<n) {
                    if (!visited_ary[xx][yy] && ary[xx][yy]==0) {
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
        area[cnt - 1] = local_area; // 결과 저장 (cnt는 1부터 시작)
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ary = new int[m][n];
        visited_ary = new boolean[m][n];
        area = new int[m * n]; // 최대 영역 수

        for (int i=0; i<k; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(str.nextToken());
            y1 = Integer.parseInt(str.nextToken());
            x2 = Integer.parseInt(str.nextToken());
            y2 = Integer.parseInt(str.nextToken());

            for (int x=x1; x<x2; x++) {
                for (int y=y1; y<y2; y++) {
                    ary[y][x] = 1;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (ary[i][j]==0 && !visited_ary[i][j]) {
                    BFS(i, j);
                }
            }
        }

        Arrays.sort(area, 0, cnt);
        // area를 정렬하고, 0(시작 인덱스)부터 cnt(마지막 인덱스) 개수만큼의 유효한 값을 가져옴
        // 0은 유효한 값이 아니므로 제외하고 가져옴. 만약 유효한 값이 다섯개인데 cnt가 6개라면 그때는 0이 한개 들어갈 수 있음.

        System.out.println(cnt);
        
        for (int i=0; i<cnt; i++) {
            System.out.print(area[i] + " ");
        }
    }   
}
