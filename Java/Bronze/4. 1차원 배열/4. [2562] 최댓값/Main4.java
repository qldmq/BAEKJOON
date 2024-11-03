import java.io.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ary[] = new int[9];
        int max = ary[0];   // 최댓값을 담을 변수
        int index = 0;

        for (int i=0; i<9; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            if (max<ary[i]) {
                max = ary[i];
                index = i+1;
            }
        }

        bw.write(String.valueOf(max) + " " + String.valueOf(index));

        br.close();
        bw.flush();
        bw.close();
    }
}
