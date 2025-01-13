import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {
    static char ary[][];
    static boolean visited_ary[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int R, C;
    static int cnto, cntv;
    static int O = 0;
    static int V = 0;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited_ary[x][y] = true;
        if (ary[x][y]=='o') {
            cnto++;
        } else if(ary[x][y]=='v') {
            cntv++;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0; i<4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                if (xx>=0 && yy>=0 && xx<R && yy<C) {
                    if (ary[xx][yy]!='#' && !visited_ary[xx][yy]) {
                        if (ary[xx][yy]=='o') {
                            cnto++;
                        } else if(ary[xx][yy]=='v') {
                            cntv++;
                        }
                        
                        queue.offer(new Point(xx, yy));
                        visited_ary[xx][yy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ary = new char[R][C];
        visited_ary = new boolean[R][C];

        for (int i=0; i<R; i++) {
            String s = br.readLine();
            for (int j=0; j<C; j++) {
                ary[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (ary[i][j]=='v' || ary[i][j]=='o') {
                    if (!visited_ary[i][j]) {
                        cnto = 0;
                        cntv = 0;
                        BFS(i, j);

                        if (cnto > cntv) {
                            O += cnto;
                        } else {
                            V += cntv;
                        }
                    }
                }
            }
        }

        System.out.print(O + " " + V);
    }
}
