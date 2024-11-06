import java.io.*;

public class Main8_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ary[] = new int[10];
        boolean bl;
        int cnt = 0;

        for (int i=0; i<10; i++) {
            ary[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int i=0; i<10; i++) {
            bl = false;
            for (int j=i+1; j<10; j++) {
                if (ary[i]==ary[j]) {
                    bl = true;
                    break;
                }
            }
            if (bl == false) {
                cnt++;
            }
        }        


        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }
}
