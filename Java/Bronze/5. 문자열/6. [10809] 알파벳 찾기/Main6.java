import java.io.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ary[] = new int[26];

        for (int i=0; i<26; i++) {
            ary[i] = -1;
        }

        String s = br.readLine();

        for (int j=0; j<s.length(); j++) {
            char ch = s.charAt(j);

            if (ary[ch -'a'] == -1) {
                // 아스키코드로 가져오기 때문에 예를 들어 baekjoon을 입력하면 맨 처음 b의 아스키코드인 98에서 a의 아스키코드인 97을 빼므로 배열의 첫번째 위치를 비교
                ary[ch - 'a'] = j;
            }
        }

        for (int k=0; k<26; k++) {
            bw.write(String.valueOf(ary[k]) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
