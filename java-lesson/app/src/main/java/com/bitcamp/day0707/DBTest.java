package com.bitcamp.day0707;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class DBTest {
  Connection CN = null;  //DB서버 연결정보
  Statement ST = null;      //명령어 생성
  ResultSet RS = null;      // 조회결과를 기억
  String msg = "";
  int Gtotal = 0; //.

  static Scanner sc = new Scanner(System.in);

  public void menu() {
    try {
      menuloop : while(true) {
        System.out.println("---------------------");
        System.out.println("메뉴 선택");
        System.out.println("1.입력 2.조회 3.삭제 4.수정  0.종료");
        System.out.print(">> ");

        switch(Integer.parseInt(sc.nextLine())) {
          case 1: insertDB(); break;
          case 2: selectAllDB(); break;
          case 3: deleteDB(); break;
          case 4: updateDB(); break;
          case 0: System.out.println("프로그램 종료"); break menuloop;
          default: System.out.println("잘못 입력하였습니다."); break;
        }
      }
    } catch(Exception EX) {System.out.println("예외 발생 : " +EX);}
  }

  public void connectDB(String driver, String url, String id, String pwd) {
    try {
      Class.forName(driver);
      CN=DriverManager.getConnection(url, id, pwd);
      System.out.println("오라클 드라이버 연결 성공");
      ST = CN.createStatement();
    } catch(Exception ex) {System.out.println("에러이유"+ex);}
  }

  public void insertDB() {
    try {
      System.out.println("\n code4자리수 입력>>> ");
      int a = Integer.parseInt(sc.nextLine());
      if((Integer.toString(a)).length() != 4) {
        System.out.println("코드 값이 4자리가 아닙니다.");
        return;
      }
      System.out.println("\n이름 입력>>> ");
      String b = sc.nextLine();
      System.out.println("제목 입력 >>>");
      String c = sc.nextLine();

      msg = "insert into test(code,name,title,wdate,cnt) values("+a+", '"+b+"', '"+c+"', sysdate, 0)";
      System.out.println(msg);
      int OK = ST.executeUpdate(msg);
      if(OK>0) {
        System.out.println(a + " 코드에 데이터 저장 성공했습니다.");
      } 
      else {System.out.println(a + "코드에 데이터 저장 실패 했습니다.");}
    } catch(Exception ex) {System.out.println("에러이유"+ex);}
  }

  public void deleteDB() {
    try {
      System.out.print("삭제할 이름 입력 >> ");
      String delete_name = sc.nextLine();
      msg = "delete from test where name = '"+delete_name+"'";
      System.out.println(msg);
      ST.execute(msg);
    } catch(Exception ex) {System.out.println("에러이유"+ex);}
  }


  public void selectAllDB() {
    try {
      ST = CN.createStatement();
      msg = "select count(*) as hit from test";
      RS = ST.executeQuery(msg);
      if(RS.next()==true) {
        Gtotal = RS.getInt("hit");
      }

      msg = "select * from test"; //문자열을 명령어 인식해서 실행하도록 Statement
      RS = ST.executeQuery(msg);

      System.out.println("\t\t\t\t전체 레코드 갯수 :"+Gtotal);
      System.out.println();
      System.out.println("코드\t이름\t제목\t날짜\t\t조회수");
      while(RS.next()==true) {
        //필드 접근해서 데이터 가져올때 getXXX()
        int ucode = RS.getInt("code");
        String uname = RS.getString("name");
        String utitle = RS.getString("title");
        Date udate = RS.getDate("wdate");
        int ucnt = RS.getInt("cnt");
        System.out.println(ucode+"\t" + uname+"\t" + utitle+"\t" + udate+"\t" + ucnt+"\t");

        System.out.println();
        //출력테스트
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
        DBTablePrinter.printTable(conn, "test");


      }
    } catch(Exception ex) {System.out.println("에러이유"+ex);}
  }

  public void updateDB() {
    try {
      System.out.print("코드 입력 >> ");
      String ecode = sc.nextLine();
      System.out.print("수정할 이름 입력 >> ");
      String ename = sc.nextLine();
      System.out.print("수정할 제목 입력 >> ");
      String etitle = sc.nextLine();
      msg = "update test set name='"+ename+"', title='"+etitle+"'  where code = "+ecode;
      System.out.println(msg);

      ST = CN.createStatement();
      int OK = ST.executeUpdate(msg);
      if(OK>0) {
        System.out.println();
        System.out.println(ecode + "데이터 수정성공");}
      else {System.out.println(ecode + "데이터 수정실패"); }

    } catch(Exception ex) {System.out.println("에러이유"+ex);}
  }

  public static void main(String[] args) {

    DBTest dbtest = new DBTest();
    dbtest.connectDB("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
    dbtest.menu();
    sc.close();
  } // main 종료
}
