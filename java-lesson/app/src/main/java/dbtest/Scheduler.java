package dbtest;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scheduler {
  Scanner sc = new Scanner(System.in);
  String msg;
  String id;
  boolean check;

  String insert_date;

  Connection conn =null;


  public void schedule() {

    loop: while (true) {
      System.out.println("1. 일정추가 2. 일정수정 3.일정삭제 4.일정완료처리 5.일정공유 0.뒤로");
      switch (Integer.parseInt(sc.nextLine())) {
        case 1: scheduleInsert(); break;
        case 2: scheduleUpdate(); break;
        case 3: scheduleDelete(); break;
        case 4: scheduleFinish(); break;
        case 5: scheduleShare(); break;
        case 0: break loop;
      }
    }
    sc.close();
  } // end method

  public void scheduleInsert() {
    try {
      Boot boot = new Boot();   
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      while (true) {
        System.out.print("등록날짜(YYYY-MM-DD 형태로 입력) : ");
        insert_date = sc.nextLine();
        check = Pattern.matches("\\d{4}-\\d{2}-\\d{2}", insert_date);
        if(check != true) {
          System.out.println("날짜 형식이 올바르지 않습니다.");
          continue;
        } break;
      }
      msg = "insert into seet_"+id+ "p_date values("+insert_date+")";
      ST.executeUpdate(msg);
      System.out.println("일정 등록이 완료되었습니다.");
    } catch (Exception ex) {}
  }
  public void scheduleUpdate() {

  }
  public void scheduleDelete() {

  }
  public void scheduleFinish() {

  }
  public void scheduleShare() {

  }



}
