import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ary[] = new int[n];

        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ary);   // 입력받은 배열을 오름차순으로 정렬한 다음 [0]과 [n-1] 위치에 있는 배열 출력
        bw.write(String.valueOf(ary[0] + " " + ary[n-1]));

        
        br.close();
        bw.flush();
        bw.close();
    }
}
