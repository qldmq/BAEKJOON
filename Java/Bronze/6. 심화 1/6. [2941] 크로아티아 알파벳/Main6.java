import java.io.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String cr[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String neword = "";

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            boolean isMatched = false;

            // 현재 위치에서 크로아티아 문자를 찾기 위해 부분 문자열 생성
            for (int j = 0; j < cr.length; j++) {
                if (i + cr[j].length() <= s.length()) {
                    neword = s.substring(i, i + cr[j].length()); // 부분 문자열 생성

                    if (neword.equals(cr[j])) {
                        cnt++;
                        i += cr[j].length() - 1; // 매칭된 경우 다음 문자로 이동
                        isMatched = true;
                        break;
                    }
                }
            }

            if (!isMatched) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
