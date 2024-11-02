import java.io.*;
import java.util.StringTokenizer;

public class Main12 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        StringTokenizer st;

        while ((s=br.readLine()) != null) {
            st = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write((a + b) + "\n");;
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

// 종료할 때 ctrl+z누르고 엔터치면 더한 값 나오고 종료됨