import java.io.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char chary[][] = new char[5][15];
        
        for (int i=0; i<5; i++) {
            String s = br.readLine();
            for (int j = 0; j<s.length(); j++) {
                chary[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<15; i++) {
            for (int j=0; j<5; j++) {
                if (chary[j][i] != '\0') {      // 이걸 안쓰면 초기화하지 않은 값도 출력하려고 하기 때문
                    // char형은 원시타입이라 null을 사용할 수 없어서 아스키코드 이용
                    System.out.print(chary[j][i]);
                }
            }
        }
    }
}
