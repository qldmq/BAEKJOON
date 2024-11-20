import java.io.*;

public class Main7 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean cp[] = new boolean[n];

        for (int i=0; i<n; i++) {
            boolean chk[] = new boolean[26];    // boolean의 초기값은 false
            String s = br.readLine();
            
            for (int j=0; j<s.length(); j++) {

                int chknum = s.charAt(j);

                if (chk[chknum - 'a'] == false) {
                    while (j<s.length()-1 && (s.charAt(j) == s.charAt(j+1))){
                        j++;
                    }
                        
                    chk[chknum - 'a'] = true;
                }
                else {
                    cp[i] = true;
                    break;
                }
                
            }
        }

        int cnt = 0;
        
        for (int i=0; i<cp.length; i++) {
            if (cp[i] == false) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
