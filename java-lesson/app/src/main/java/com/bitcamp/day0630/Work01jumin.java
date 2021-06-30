package com.bitcamp.day0630;

import java.util.Scanner;

public class Work01jumin {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String min = sc.nextLine();
    System.out.println(min.length());

    String min1 = min.substring(0,6);
    String min2 = min.substring(7,14);

    System.out.println("******-"+ min2);

    switch(min.charAt(7)) {
      case '1':
        System.out.println("남자입니다"); break;
      case '2':
        System.out.println("여자입니다"); break;
      case '3':
        System.out.println("남자입니다"); break;
      case '4':
        System.out.println("여자입니다"); break;
      default:
        System.out.println();
    }
    //문제1 총자릿수 13자리수, 14자릿수
    //문제2 ******-1541965 로 나오게 출력
    //문제3 1/3 남자 2/4여자 switch활용
    //length(),substring(),indexOf(),charAt() 활용할것
  }

}
