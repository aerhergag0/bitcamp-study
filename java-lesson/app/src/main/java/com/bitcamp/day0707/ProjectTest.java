package com.bitcamp.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import dbtest.DB_Print;

public class ProjectTest extends DB_Print{
  Connection CN = null;  //DB서버 연결정보
  Statement ST = null;      //명령어 생성
  ResultSet RS = null;      // 조회결과를 기억
  String msg = "";
  static Scanner sc = new Scanner(System.in);

  //30자 가운데정렬배너
  public void printbanner(String str) {
    System.out.println();
    System.out.println("------------------------------");
    for(int i=0; i<(30-str.length())/2; i++) {
      System.out.print(" ");
    }
    System.out.println(str);
    System.out.println("------------------------------");
    System.out.println();
  }

  //로그인 메뉴 화면
  public void loginmenu() {
    printbanner("Login");
    loginloop : while(true) {
      try {
        System.out.println();
        System.out.println("1.로그인 2.회원가입 3.로그아웃 4.회원 목록 0.종료");
        System.out.print(">> ");
        switch(Integer.parseInt(sc.nextLine())) {
          case 1: signIN(); break;
          case 2: signUP(); break;
          case 3: break;
          case 4: db_print("Select * from ptlogin"); break;
          case 0: printbanner("End Program"); break loginloop;
        }
      } catch(Exception e) {System.out.println(e);}
    } // loop end
  }

  //회원가입
  public void signUP() {
    try {
      System.out.print("만들 ID 입력 : ");
      String signupID = sc.nextLine();
      System.out.print("새 패스워드 입력 : ");
      String signupPwd = sc.nextLine();
      System.out.print("이름 입력 : ");
      String signupName = sc.nextLine();
      System.out.print("핸드폰 번호 입력 : ");
      String signupPhone = sc.nextLine();
      System.out.print("이메일 입력 : ");
      String signupEmail = sc.nextLine();
      String msg =String.format("insert into ptlogin values('%s','%s','%s','%s','%s')",signupID,signupPwd,signupName,signupPhone,signupEmail);
      ST.executeUpdate(msg);
    } catch (Exception ex) {System.out.println(ex);}
  }

  //로그인하기
  public void signIN() {

  }

  //main
  public static void main(String[] args) {
    DBConnection dbcon = new DBConnection();
    ProjectTest ptest = new ProjectTest();
    ptest.connectDB("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
    ptest.printbanner("scheduler program");
    ptest.loginmenu();
  } //end main

  public void connectDB(String driver, String url, String id, String pwd) {
    try {
      Class.forName(driver);
      CN=DriverManager.getConnection(url, id, pwd);
      System.out.println("오라클 드라이버 연결 성공");
      ST = CN.createStatement();
    } catch (Exception ex) {System.out.println(ex);}
  }
}

// ptlogin 테이블