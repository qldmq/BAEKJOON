// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;

// public class Main6 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         // int a = Integer.parseInt(bf.readLine());
//         // int b = Integer.parseInt(bf.readLine());
//         // Integer.parseInt() 메서드는 공백이 있는 문자열을 정수로 반환할 수 없어서 두 정수 a, b를 공백으로 구분하면 에러가 남
//         // 그래서 readLine()으로 전체 줄을 읽고, split(" ") 메서드를 사용해서 구분으로 나누어야함

//         String ary[] = bf.readLine().split(" ");
//         int a = Integer.parseInt(ary[0]);
//         int b = Integer.parseInt(ary[1]);

//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write(a+b+"");  // bw.write(a+b); 이 코드는 a와 b를 정수로 더한 결과를 BufferedWriter에 직접 입력하는 코드임
//                         // 그러나 BufferedWriter.write(int) 메서드는 정수를 직접 받아들이고, 이를 문자로 변환하지 않기 때문에, 출력 결과가 예상과 다를 수 있음
//                         // 그렇기에 bw.write(a + b + ""); 이 코드를 써서 a와 b를 더한 후, 빈 문자열을 더하여 결과를 문자열로 반환해야함
//                         // 문자열로 변환된 값을 BufferedWriter에 쓰게되므로, 원하는 결과인 a+b의 합이 문자열로 출력됨
//         bw.flush();
//         bw.close();
//     }
// }
// 런타임 에러남
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            String s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            bw.write(a+b+"\n");
        }
       
        br.close();
        bw.flush();
        bw.close();
    }
}