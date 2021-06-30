package com.bitcamp.day0630;

import java.io.InputStream;
import java.util.Scanner;

public class Work02emp {
  public static void main(String[] args) {
    InputStream is = System.in;
    Scanner sc = new Scanner(is);
    int sabun = 2000;
    String name = "길동";

    while(true) {
      try {
        System.out.print("사번입력 >>> ");
        sabun = Integer.parseInt(sc.nextLine());
        System.out.print("이름입력 >>> ");
        name = sc.nextLine();
        break;
      }
      catch (Exception e) {
        System.out.println("값을 잘못 입력하였습니다");
      }
    }
    System.out.println();
    System.out.println("사번 = " +sabun);
    System.out.println("이름 = " +name);
    sc.close();
  }
}
/*
public class Work02emp {
  public static void main(String[] args) {
    try {
      InputStream is = System.in;
      Scanner sc = new Scanner(is);
      int sabun = 2000;
      String name = "길동";

      System.out.print("사번입력 >>> ");
      sabun = sc.nextInt(); //숫자,문자 다 입력해서 단점 해결

      sc.nextLine();
      System.out.print("이름입력 >>> ");
      name = sc.nextLine();

      System.out.println();
      System.out.println("사번 = " +sabun);
      System.out.println("이름 = " +name);

    }
    catch (Exception e) {
      System.out.println("값을 잘못 입력하였습니다");
    }
  }
}
 */
// 문제 키보드 입력 Scanner 클래스 반드시 입력해서 출력,예외처리, 형변환 + 반복문 쓸것
// 