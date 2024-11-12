// 구글링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main9_2 {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        // 1. st.nextToken()을 통해 첫번째와 두번째 숫자를 각각 문자열로 가져옴
        // 2. StringBuilder 객체를 사용하여 문자열을 뒤집음. reverse() 메서드는 StringBuilder의 내용을 뒤집음
        // 3. toString() 메서들를 호출하여 뒤집힌 문자열을 String으로 변환한 후, Integer.parseInt()를 사용하여 정수로 변환
		
		System.out.print(A > B ? A:B);
		// 삼항 연산자를 사용하여 A와 B중 더 큰 값을 선택
	}
}