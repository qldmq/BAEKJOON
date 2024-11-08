import java.io.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        
        for (int i=0; i<t; i++) {
            String st = new String(br.readLine());
            int a = st.length();
            bw.write(st.charAt(0) + "" + st.charAt(a-1) + "\n");
            // 중간에 ""를 안써주면 st.charAt(0)과 st.charAt(a)의 문자 유니코드 값이 더해져서 숫자로 출력되기 때문에 나눠줘야함
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
