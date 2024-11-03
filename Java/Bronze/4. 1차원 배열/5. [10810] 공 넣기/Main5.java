import java.io.*;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ary[] = new int[n];

        for (int b=0; b<m; b++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            for (int z=i-1; z<=j-1; z++) {  
                ary[z] = k;
            }
        }

        for (int c = 0; c<n; c++) {
            bw.write(ary[c] + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
