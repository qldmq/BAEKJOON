import java.io.*;
import java.util.StringTokenizer;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ary[] = new int[n];

        for (int a=0; a<n; a++) {
            ary[a]=a+1;
        }
        
        for (int b=0; b<m; b++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int num = ary[i-1];
            ary[i-1] = ary[j-1];
            ary[j-1] = num;
        }
        
        for (int c=0; c<n; c++) {
            bw.write(String.valueOf(ary[c]) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
