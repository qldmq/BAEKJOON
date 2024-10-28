import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int ary[] = new int[t];

        for (int i=0; i<t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ary[i] = a+b;
        }
        sc.close();

        for (int i=0; i<t; i++) {
            System.out.println(ary[i]);
        }
    }
}
