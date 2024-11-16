import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ary[] = new int[26];
        String s = br.readLine();

        for (int i=0; i<s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {   // 대문자 범위
                ary[s.charAt(i) - 65]++;    // 해당 인덱스의 값 1 증가
                // ary[s.charAt(i) - 'A']; 로 써도 됨
            }
            else if (97<=s.charAt(i) && s.charAt(i) <= 122) {
                ary[s.charAt(i) - 97]++;
            }
        }

        int max = -1;   // a-'a'는 0이 나오기 때문
        char ch = '?';  
        // '?' : 작은 따옴표로 감싸진 것은 단일 문자 리터럴을 나타내고, 이는 char 타입으로, 단 하나의 문자를 저장할 수 잇음
        // "?" : 큰 따옴표로 감싸진 것은 문자열 리터럴을 나타냄. 이는 String 타입으로, 하나 이상의 문자를 저장할 수 있음

        for (int i=0; i<26; i++) {
            if (ary[i] > max) {
                max = ary[i];
                ch = (char) (i+65);     // 대문자로 출력해야하므로 65를 더해줌
            }
            else if (ary[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}

// 대문자의 10진은 65부터 (65=A)
// 소문자의 10진은 97부터 (97=a)
