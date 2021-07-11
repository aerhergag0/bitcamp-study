package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

  Scanner keyScan = new Scanner(System.in);
  String msg;
  String id;
  String pw;
  ResultSet RS;

  Scheduler scheduler = new Scheduler();

  public String login() {
    try {
      Boot boot = new Boot();   
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      loop : while (true) {

        // 아이디 입력
        while (true) {
          System.out.print("아이디 : ");
          id = keyScan.nextLine();
          if (id.isEmpty()) {
            System.out.println("아이디를 입력하여 주세요."); continue;
          } else { break; }
        }

        // 비밀번호 입력
        while (true) {
          System.out.print("비밀번호 : ");
          pw = keyScan.nextLine();
          if (pw.isEmpty()) {
            System.out.println("비밀번호를 입력하여 주세요."); continue;
          } else { break; }
        }

        // 아이디, 비밀번호 검사
        msg = "select * from profile where id='"+id+"'";
        RS = ST.executeQuery(msg);
        if (RS.next() == false) {
          System.out.println("아이디가 존재하지 않습니다.");
        } else {
          msg = "select * from profile where id='"+id+"'";
          RS = ST.executeQuery(msg);
          while (RS.next() == true) {
            if (RS.getString("pw").equals(pw)) {
              System.out.println("로그인 되었습니다."); scheduler.schedule(); break loop;
            } else { System.out.println("비밀번호가 일치하지 않습니다.");}
          }
        }
      }
    } catch (Exception e) {}
    return id;
  }
}