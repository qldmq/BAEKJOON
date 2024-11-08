import java.io.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String st = new String(br.readLine());
        bw.write(String.valueOf(st.length()));

        br.close();
        bw.flush();
        bw.close();
    }
}
