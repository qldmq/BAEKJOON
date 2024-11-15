import java.io.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<=n; i++) {
            for (int j=0; j<n-i; j++) {
                System.out.print(" ");
            }
            for (int k=0; k<(i-1)*2+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<n-i; j++) {
                System.out.print(" ");
            }
            for (int k=(i-1)*2+1; k>0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
