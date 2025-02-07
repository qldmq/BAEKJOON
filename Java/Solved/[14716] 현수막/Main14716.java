import java.io.*;
import java.util.StringTokenizer;

public class Main14716 {
    static int ary[][];
    static boolean visited_ary[][];
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
    static int M, N;

    public static void DFS(int x, int y){

        visited_ary[x][y] = true;
        
        for(int i=0; i<8; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx>=0 && yy>=0 && xx<M && yy< N) {
                if (ary[xx][yy] == 1 && !visited_ary[xx][yy]){
                    DFS(xx, yy);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ary = new int[M][N];
        visited_ary = new boolean[M][N];

        for (int i=0; i<M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            
            for(int j=0; j<N; j++) {
                ary[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int cnt = 0;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if (ary[i][j] == 1 && !visited_ary[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
