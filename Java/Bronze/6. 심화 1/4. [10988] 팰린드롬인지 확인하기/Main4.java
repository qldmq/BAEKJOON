import java.io.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String reverse = s;
        StringBuffer sb = new StringBuffer(reverse);
        reverse = sb.reverse().toString();

        if (s.equals(reverse)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
