import java.util.Scanner;;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.close();

        for (int i=1; i<=n/4; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
