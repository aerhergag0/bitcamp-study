package test01;

import java.util.Scanner;

public class QuizService {
  Scanner sc = new Scanner(System.in);
  Quiz quiz = new Quiz();

  public void quizMake() {
    System.out.printf("%d * %d = ?%n",quiz.ran1,quiz.ran2);
  }

  public void quizAnswerCheck() {
    int userAnswer = Integer.parseInt(sc.nextLine());
    if(quiz.ans == userAnswer)
      System.out.println("정답입니다");
    else
      System.out.println("오답입니다");
  }
}
