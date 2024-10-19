/**
 * 2.[1000] A+B
 * 백준은 class 이름을 Main으로 해야함
 */

import java.util.Scanner;

public class N2_1000_AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a+b);

        sc.close();
    }
}