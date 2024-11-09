public class Main4 {
    public static void main (String[] args) throws Exception {
        int a = System.in.read();
        // System.int.read()는 바이트를 읽고 그 바이트의 유니코드 값을 int로 반환함
        // 하나의 문자를 읽는것은 read(), 한줄을 읽는것은 readLine()

        System.out.print(a);
    }
}
    