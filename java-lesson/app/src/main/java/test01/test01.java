package test01;

import java.util.Scanner;

public class test01 {
  public static void main(String[] args) {
    questionLoop:
      while (true) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문제풀까요?(y/n) : ");
        String check = sc.next();
        if(check =='y') { 

          int ran1 = (int) ((Math.random() * 99) + 1); // 1~100;
          int ran2 = (int) ((Math.random() * 99) + 1); // 1~100;

          System.out.printf("%d * %d = ?%n", ran1, ran2);
          System.out.print(">> : ");
          answerLoop: // 정답확인
            while (true) {
              int ans = Integer.parseInt(sc.nextLine());
              if (ans == ran1 * ran2) {
                System.out.println("정답입니다");
                break answerLoop;
              } else {
                System.out.println("오답입니다");
              }
            } //answerLoop end
        }
        else if(check=="n")
          break questionLoop;
      }//questionLoop end
  }
}