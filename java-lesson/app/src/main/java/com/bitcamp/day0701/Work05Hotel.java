package com.bitcamp.day0701;

import java.util.Scanner;

public class Work05Hotel {
  static Scanner sc = new Scanner(System.in);
  int checkFloor, checkRoom;
  String[][] checkName = new String[3][5];
  int[][] room = new int[3][5];

  public static void main(String[] args) {

    Work05Hotel ht = new Work05Hotel();
    ht.map();
    ht.process();
    sc.close();
  }
  public void checkIn() {
    try {
      System.out.println("몇 층에 투숙?");
      System.out.print(">> ");
      checkFloor = sc.nextInt();

      System.out.println("몇 호에 투숙?");
      System.out.print(">> ");
      checkRoom = sc.nextInt();
      sc.nextLine();
      if(checkName[checkFloor-1][checkRoom-1] != null) {
        System.out.println("이미 예약된 방입니다.");
        return;
      }
      System.out.println("투숙객 이름?");
      System.out.print(">> ");
      checkName[checkFloor-1][checkRoom-1] = sc.nextLine();
      System.out.println("예약완료");
    } catch (Exception e) {
      System.out.println("잘못된 값을 입력하였습니다.");
    }
  }

  public void checkOut() {
    try {
      System.out.println("퇴실할 층?");
      System.out.print(">> ");
      checkFloor = sc.nextInt();

      System.out.println("퇴실할 호?");
      System.out.print(">> ");
      checkRoom = sc.nextInt();
      if(checkName[checkFloor-1][checkRoom-1] == null) {
        System.out.println("이미 비어있는 방입니다.");
        return;
      }
      checkName[checkFloor-1][checkRoom-1] = null;
      System.out.println("퇴실완료");
    }catch(Exception e) {
      System.out.println("잘못된 값을 입력하였습니다.");
    }
  }

  public void map() {
    System.out.println("[투숙 현황]");
    for(int i =0; i<3; i++){
      for(int b =0; b<5; b++){
        System.out.print((i+1)+"0"+(b+1)+"\t");
      }
      System.out.println();
      for(int j=0; j<5; j++){
        if(this.checkName[i][j] == null){
          System.out.print("\t");
          continue;
        }
        System.out.print(this.checkName[i][j]+"\t"); 
      }
      System.out.println("\n-----------------------------------------------------------");  
    }
  }

  public void list() {
    System.out.println("\n[ list ]");
    for(int i=0; i<3; i++) {
      for(int j=0; j<5; j++) {
        if(checkName[i][j] == null) {
          System.out.print(" "+(i+1)+ "0"+(j+1)+"호"+"□\t"+"\t");
        }
        else {
          System.out.print(" "+(i+1)+ "0"+(j+1)+"호"+"■\t"+checkName[i][j]+"\t");
        }

      }
      System.out.println();
    }
  }

  public void process() {
    Work05Hotel ht = new Work05Hotel();
    loop : while(true) {
      System.out.println();
      System.out.println("1.투숙 2.퇴실 3.map 4.list 9.종료? ");
      System.out.print(">> ");

      int menuInput = sc.nextInt();
      switch(menuInput) {
        case 1: ht.checkIn(); break;
        case 2: ht.checkOut();break;
        case 3: ht.map(); break;
        case 4: ht.list();break;
        case 9: System.out.println("프로그램종료"); break loop;
        default :
          System.out.println("잘못 입력하였습니다.");
      }
    }
  }
}
