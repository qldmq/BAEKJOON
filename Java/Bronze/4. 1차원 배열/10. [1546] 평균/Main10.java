import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ary[] = new int[n];

        for (int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);
        int max = ary[n-1];
        double sum = 0;

        for (int j=0; j<n; j++) {
            sum += ((double)ary[j]/max)*100;   // (double)을 통해 부동소수점 나눗셈을 수행해서 소수점 이하의 값을 포함하여 출력
        }

        bw.write(String.valueOf(sum/n));

        br.close();
        bw.flush();
        bw.close();
    }
}
