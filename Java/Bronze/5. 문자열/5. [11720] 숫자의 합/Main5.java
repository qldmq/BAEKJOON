import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String s = new String(br.readLine());

        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            // Integer.parseInt는 문자열을 인자로 받아야하기 때문에 String.valueOf를 통해 문자열로 변환한 다음 int로 바꿔줘야함
        }

        // 위 for문은 아래처럼 쓸 수 있음
        // for(int i = 0; i < n; i++) {
		// 	sum += s.charAt(i)-'0';
		// }

        bw.write(String.valueOf(sum));

        br.close();
        bw.flush();
        bw.close();
    }    
}
