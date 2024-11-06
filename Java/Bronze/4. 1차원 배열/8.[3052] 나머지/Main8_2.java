import java.io.*;
import java.util.HashSet;

public class Main8_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<Integer>();
        // Hash는 중복되는 값을 허용하지 않음
        
        for (int i = 0; i<10; i++) {
            hs.add(Integer.parseInt(br.readLine()) % 42);
            // 입력받은 값의 나머지 값을 add메소드를 HashSet에 저장
        }
        br.close();
        System.out.print(hs.size());

    }
}
