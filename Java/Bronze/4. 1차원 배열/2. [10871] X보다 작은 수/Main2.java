import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int x = Integer.parseInt(s.split(" ")[1]);
        int a[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] < x) {
                bw.write(String.valueOf(a[i]) + " ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
