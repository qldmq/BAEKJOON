import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2210 {
    static String numMap[][] = new String[5][5];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static HashSet<String> answer = new HashSet<>();

    public static void DFS(int x, int y, String route, int cnt) {
        if(cnt == 5) {
            answer.add(route);
            return;
        }

        for (int i=0; i<4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx>=0 && yy>=0 && xx<5 && yy<5) {
                DFS(xx, yy, route+numMap[xx][yy], cnt+1);
            }
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                numMap[i][j] = st.nextToken();
            }
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                DFS(i, j, numMap[i][j], 0);
            }
        }
        
        System.out.println(answer.size());
    }
}
