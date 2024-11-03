import java.io.*;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());    // StringTokenizer은 한 줄의 입력을 읽고 나서 사용해야 함

        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        
        int v = Integer.parseInt(br.readLine());

        for (int j=0; j<n; j++) {
            if (ary[j]==v) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
                
        br.close();
        bw.flush();
        bw.close();
    }
}
