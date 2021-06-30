package com.bitcamp.day0628;

import java.util.Scanner;

public class Work05Hotel {
  // 생성자 클래스이름, 리턴값X, void기술X
  // 생성자사용은 new키워드 다음에 기술     클래스ob =new 클래스( )
  // 생성자는 중복가능, 기본생성자 생략가능
  // 멤버필드 = 전역변수 private 
  private int floor;  //층 = 행3층
  private int room;   //호 = 열5호  3층*5열 = 15방구성
  private String[][] name = new String[3][5];
  private String title;

  public Work05Hotel() {}
  public Work05Hotel(String name) {    
    System.out.println("***"+name+"***");
    System.out.println( name+"방문을 축하합니다");}
  public Work05Hotel(String name, int year) {}

  public void process() {
    Scanner sc = new Scanner(System.in);
    int sel = 9;
    while(true) {
      System.out.println("\n1.투숙 2.퇴실 3.map 4.list 9.종료");
      System.out.print(">>> ");
      sel = Integer.parseInt(sc.nextLine());
      if(sel==9) {
        System.out.println("호텔예약 프로그램 종료합니다.");
        System.exit(1);
      }

      switch(sel) {

      }
    }
  }
  public void checkIn() {

  }
  public void checkOut() {

  }
  public void map() {

  }
  public void list() {

  }

  public static void main(String[] args) {
    Work05Hotel wh = new Work05Hotel("");
    wh.process();


  }
}
