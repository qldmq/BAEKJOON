import java.io.*;
import java.util.StringTokenizer;

public class Main1389 {
    static int ary[][];
    static final int INF = 999999999;   // final은 변경할 수 없는 상수임을 의미
    // final 빼고 써도 오류안남. 안전장치일뿐.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ary = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				ary[i][j] = INF;
				if(i == j) ary[i][j] = 0;
			}
		}

        for (int i=0; i<m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            ary[a][b] = ary[b][a] = 1;
        }

        for(int k=1; k<=n; k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					ary[i][j] = Math.min(ary[i][j], ary[i][k] + ary[k][j]);
				}
			}
		}

		int temp = INF;
		int result = 0;
		
		for(int i=1;i<=n;i++) {
			int total = 0;
			for(int j=1;j<=n;j++) {
				total += ary[i][j];
			}
			
			if(temp > total) {
				temp = total;
				result = i;
			}	
		}

        System.out.println(result + "\n");
    }
}