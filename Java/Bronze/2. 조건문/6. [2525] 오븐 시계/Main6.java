import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        sc.close();

        b += c;
        if (b>59) {
            a += (b/60);
            a = a%24;
            b = b%60;
        }

        System.out.println(a + " " + b);
    }
}
