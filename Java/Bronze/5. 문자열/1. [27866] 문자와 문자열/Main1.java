import java.io.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st = new String(br.readLine());
        int a = Integer.parseInt(br.readLine());
        bw.write(st.charAt(a-1));

        br.close();
        bw.flush();
        bw.close();
    }
}
