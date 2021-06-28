package com.bitcamp.day0628;

import java.util.Scanner;

public class CampTest1 {
  static Scanner sc = new Scanner(System.in);
  static boolean[] camp = new boolean[5];
  static int num = 0;
  public static void main(String[] args) {

    System.out.println("[캠프 예매]");
    campView();
    menuloop : while(true) {
      try {

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("1.예약  2.퇴실  3.보기  9.종료");
        System.out.println("-------------------------------");
        System.out.print(">> ");

        int menuSelect = Integer.parseInt(sc.nextLine());

        switch (menuSelect) {
          case 1: campCheckIn();  break;
          case 2: campCheckOut(); break;
          case 3: campView();         break;
          case 9: 
            System.out.println("프로그램 종료");
            break menuloop;
          default:
            System.out.println("잘못된 번호 입력입니다.");
            break;
        }
      } catch (Exception ex){
      }
    }
  }

  static void campCheckIn() {
    System.out.print("캠핑장 번호 입력 >> ");
    num = Integer.parseInt(sc.nextLine());
    if(num<1 || num>5) {
      System.out.println(num + " 번호를 사용할 수 없습니다.");
    }
    else{
      if(camp[num-1]==true) {
        System.out.println("이미 예약되어있는 캠핑장입니다.");
      }
      else {
        camp[num-1] = true;
        System.out.println(num+"번에 캠핑장 예약 완료했습니다.");
      }
    }
  }
  static void campCheckOut() {
    System.out.print("퇴실캠핑번호 입력>>> ");
    num = Integer.parseInt(sc.nextLine());
    if(num<1 || num>5) {
      System.out.println(num + " 번호를 사용할 수 없습니다.");
    }
    else{
      if(camp[num-1]==false) {
        System.out.println("이미 비어있는 캠핑장입니다.");
      }
      else {
        camp[num-1] = false;
        System.out.println(num+"번에 캠핑장 퇴실 완료했습니다.");
      }
    }
  }
  static void campView() {
    for(int i=0; i<camp.length; i++) {
      if(camp[i]==true) {
        System.out.println(" "+(i+1)+"번째 캠프 ■ 사용중입니다.");
      }
      else {
        System.out.println(" "+(i+1)+"번째 캠프 □ 비어있습니다.");
      }
    }
  }
}
