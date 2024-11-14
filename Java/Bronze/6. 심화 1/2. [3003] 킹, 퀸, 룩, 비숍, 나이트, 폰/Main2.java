import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());  
        
        k = 1 - k;
        q = 1 - q;
        l = 2 - l;
        b = 2 - b;
        n = 2 - n;
        p = 8 - p;

        System.out.printf("%d %d %d %d %d %d", k, q, l, b, n, p);
    }
}
