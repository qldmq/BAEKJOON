import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();     // 범위가 10^12까지인 수를 입력받아야 하기 때문 
        long b = sc.nextLong();     // int는 그 이상
        long c = sc.nextLong();     // 10^12는 너무 큰 수라 객체지향인 자바는 못함

        sc.close();

        System.out.print(a + b + c);
    }
}