import java.io.*;

public class Main11 {
   public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);  // 입력받은 문자열 s를 공백을 기준으로 나누고, 그중에서 [0]번째에 있는 요소를 int형으로 가져와서 a에 넣음
            int b = Integer.parseInt(s.split(" ")[1]);
            if (a==0 && b==0) {
                break;
            }
            bw.write(String.valueOf(a+b + "\n"));
        }
        
        br.close();
        bw.flush();
        bw.close();
   } 
}
