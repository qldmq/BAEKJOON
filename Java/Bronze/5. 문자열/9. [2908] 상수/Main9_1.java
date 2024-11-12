// 내가 푼거
import java.io.*;
import java.util.StringTokenizer;

public class Main9_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String sa = st.nextToken();
        String sb = st.nextToken();

        StringBuilder sb1 = new StringBuilder(sa);
        char ch = sa.charAt(0);
        sb1.setCharAt(0, sb1.charAt(2));
        sb1.setCharAt(2, ch);

        StringBuilder sb2 = new StringBuilder(sb);
        // StringBuilder는 하나의 문자열을 처리하기 위해 설계된 케이스이기 때문에 한번 더 만들어줘야함
        ch = sb.charAt(0);
        sb2.setCharAt(0, sb2.charAt(2));
        sb2.setCharAt(2, ch);

        int a = Integer.parseInt(sb1.toString());
        // Integer.pasreInt() 메서드는 String을 인수로 받기 때문에 toString() 메서드를 사용해서 StringBuilder객체를 String으로 변환한 후 정수로 변환해야 함
        int b = Integer.parseInt(sb2.toString());

        System.out.println(Math.max(a,b));
    }
}
