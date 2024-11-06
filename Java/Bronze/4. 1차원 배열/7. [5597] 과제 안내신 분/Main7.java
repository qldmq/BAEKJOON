import java.io.*;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ary[] = new int[30];

        for(int i=0; i<30; i++) {
            ary[i] = i+1;
        }   // 이 for문 굳이 안써줘도 됨.
            // 아래 for문에서 ary[n-1]에 1을 넣고 비교만 해줘도 됨

        for (int j=0; j<28; j++) {
            int n = Integer.parseInt(br.readLine());
            ary[n-1] = 0;
        }

        for (int k=0; k<30; k++) {
            if (ary[k]!=0) {
                bw.write(String.valueOf(ary[k]) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
