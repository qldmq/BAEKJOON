import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        if (score >=90 && score <= 100) {
            System.out.println("A");
        }else if (score >=80 && score < 90) {
            System.out.println("B");
        }else if (score >=70 && score < 80) {
            System.out.println("C");
        }else if(score >= 60 && score < 70) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}



// import java.util.Scanner;

// public class Main2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int score = sc.nextInt();

//         sc.close();

//         if(score>0 && score<=100){
//             switch (score/10) {
//                 case 10:
//                 case 9:
//                     System.out.print("A");
//                     break;      // switch문은 break;가 없으면 case에 들어간 이후 아래의 모든 case들을 순차적으로 실행하기 때문에 break를 써줘야함
//                 case 8:
//                     System.out.print("B");
//                     break;
//                 case 7:
//                     System.out.print("C");
//                     break;
//                 case 6:
//                     System.out.print("D");
//                     break;
//                 default:
//                     System.out.print("F");
//                     break;
//             }
//         }
//     }
// }
