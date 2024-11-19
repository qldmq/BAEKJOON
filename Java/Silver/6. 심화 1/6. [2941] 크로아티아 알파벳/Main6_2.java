import java.io.*;

public class Main6_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int cnt = 0;
        int len = s.length();
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'c' && i < len-1) {    // 단일 문자는 ''로 묶어야함
            // i가 문자열의 끝에 가까운 경우 인덱스 범위를 벗어날 수 있어서 i < len-1 써줌
                if (s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
                    i++;    // i+1까지가 하나의 단어이므로 i를 1 증가시켜서 다음 문자를 건너뛰어야함
                }
            }
            else if (ch == 'd' && i < len-1) {
                if (s.charAt(i+1) == 'z' && i < len-2) {
                    if (s.charAt(i+2) == '=') {
                        i += 2;
                    }
                }
                else if (s.charAt(i+1) == '-') {
                    i++;
                }
            }
            else if ((ch == 'l' || ch ==  'n') && i < len-1) {
                if (s.charAt(i+1) == 'j') {
                    i++;
                }
            }
            else if ((ch == 's' || ch == 'z') && i < len-1) {
                if (s.charAt(i+1) == '=') {
                    i++;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }    
}
