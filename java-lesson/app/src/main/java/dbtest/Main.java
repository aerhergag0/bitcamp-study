package dbtest;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    SignUp signup = new SignUp();
    Login login = new Login();
    Edit edit = new Edit();
    Leave leave = new Leave();

    System.out.println("일정관리시스템");
    while (true) {
      System.out.println("1. 로그인 2. 회원가입 0. 종료");
      System.out.print("번호 입력 : ");
      String num = keyScan.nextLine();

      loop : while (num.equals("1") == true) {
        login.login();
        String id = login.id;

        while (true) {
          System.out.println("메뉴를 선택하여 주세요.");
          System.out.println("1. 회원정보 수정 2. 회원탈퇴 0. 로그아웃");
          System.out.print("번호 입력 : ");
          String lognum = keyScan.nextLine();

          if (lognum.equals("1")) {edit.edit(id);}
          if (lognum.equals("2")) {leave.leave(id); break loop;}
          if (lognum.equals("0")) {System.out.println("로그아웃 하였습니다."); break loop;}
          else {System.out.println("잘못 입력하셨습니다. 다시 입력하여 주세요.");}
        }
      }

      if (num.equals("2")) {signup.signup();}
      if (num.equals("0")) {System.out.println("프로그램을 종료합니다."); break;}
      else {System.out.println("잘못 입력하셨습니다. 다시 입력하여 주세요.");}
    }
  }
}