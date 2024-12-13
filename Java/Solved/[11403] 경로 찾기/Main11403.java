import java.io.*;
import java.util.StringTokenizer;

public class Main11403 {
    public static void main(String[] args) throws Exception {
        int ary[][];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ary = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샬 알고리즘 : 거쳐가는 정점을 기준으로 알고리즘을 수행, '모든 정점'에서 '모든 정점'으로의 최단 경로를 구함
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (ary[j][i]==1 && ary[i][k]==1) {
                        ary[j][k] = 1;
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }
}
