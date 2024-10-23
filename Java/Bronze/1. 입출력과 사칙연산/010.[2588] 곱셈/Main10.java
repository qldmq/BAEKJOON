import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();

        sc.close();

        System.out.println(a * (b.charAt(2) - '0'));  // 변수.cahrAt(위치) : 지정한 위치의 문자를 가져옴
        System.out.println(a * (b.charAt(1) - '0'));  // - '0'은 문자를 숫자로 변환함
        System.out.println(a * (b.charAt(0) - '0'));
        System.out.println(a * Integer.parseInt(b));  // String 타입으로 입력받은 b를 int 타입으로 변환
        // Integer.parseInt(변수) 를 통해 String 타입의 변수를 Int형으로 변환
    }
}