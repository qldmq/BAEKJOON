import java.io.*;
import java.util.StringTokenizer;

public class Main9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ary[] = new int[n];

        for (int i=0; i<n; i++) {
            ary[i] = i+1;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;    // 입력받은 값에서 1을 뺀 값을 저장
            int right = Integer.parseInt(st.nextToken()) - 1;

            while (left < right) {
                int temp = ary[left];   // 위에서 1을 뺀 값을 넣었기 때문에 입력받은 값에서 1을 뺀 위치에 값을 저장
                ary[left++] = ary[right];   // left++는 후위 증가 연산자이기 때문에 문장을 실행 후 left를 증가함
                ary[right--] = temp;
            }
        }

        for (int i=0; i<ary.length; i++) {
            bw.write(String.valueOf(ary[i]) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
