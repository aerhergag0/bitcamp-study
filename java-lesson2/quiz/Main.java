package org.zerock.quiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //문제를 풀것인지 확인
        Scanner scanner = new Scanner(System.in);
        System.out.println("문제를 풀까요?");
        String choice = scanner.nextLine();

        //랜덤한 숫자 두개를 보여준다.
        int num1 = (int)(Math.random() * 100) + 1;
        int num2 = (int)(Math.random() * 100) + 1;

        System.out.println(num1 + " * " + num2);

        //사용자가 곱의 값을 입력
        int answer = Integer.parseInt(scanner.nextLine());

        //정답/오답 체크
        int correctAnswer = num1 * num2;

        if(answer == correctAnswer){
            System.out.println("Correct");
        }else {
            System.out.println("Wrong");
        }


    }
}
