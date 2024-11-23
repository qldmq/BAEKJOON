import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ary[][] = new int[9][9];
        int max = 0;
        int x = 1;
        int y = 1;

        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int k=0; k<9; k++) {
                if (max<ary[i][k]) {
                    max = ary[i][k];
                    x = i+1;
                    y = k+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);
    }
}
