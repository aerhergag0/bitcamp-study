package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View_F {
  Banner banner = new Banner();
  ShowTable showtable = new ShowTable();

  Scanner sc = new Scanner(System.in);
  ResultSet rs = null;
  int i = 0;

  /* 이테이블은 로그인을 하게되면  // 최종메뉴 System.out.println("1.개인일정 2.완료일정 3.공유일정 4.회원정보관리 0.로그아웃");
  여기서 완료일정을 누르면 보여지는 것임 

  들어오면 먼저 리스트를 보여주고 삭제할수있고 뒤로가기할수있고 ( 삭제하기, 뒤로가기(0) )*/

  public void view_f(String id){
    try {
      System.out.println(id +"님 안녕하세요 완료 일정 목록을 출력합니다");
      f_view(id);//f_view 값을 불러옴 login id 값을줌
      while(true) {
        System.out.println("완료 일정 테이블 입니다. 1.완료일정삭제 0. 뒤로가기 ");
        String i = sc.nextLine();
        boolean check = Pattern.matches("^[0-9]*$", i);
        if(check == false) {continue;}
        if(i.isEmpty()) {continue;}
        if (i.equals("1")) {f_delete(id);break;}
        if(i.equals("0")) {
          return;
        }

        else {
          System.out.println("올바르지 않은 번호입니다."); 
          System.out.println("완료 일정 테이블 입니다. 1.완료일정삭제 0. 뒤로가기 ");
          i = sc.nextLine();
        }
      }
    } catch (Exception E) {}
  }


  public void f_delete(String id){

    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      while(true) {
        System.out.println("삭제하실 일정 번호를 적어주세요 0:뒤로가기");
        String i = sc.nextLine();
        boolean check = Pattern.matches("^[0-9]*$", i);
        if(check == false) {continue;}
        if(i.equals("0")) {
          break;
        }
        if(i.isEmpty()) {
          continue;
        }
        String msg = "select f_id from f_seet_"+id+"" ;
        rs = ST.executeQuery(msg);
        msg = "select f_id from f_seet_"+id+" where f_id ="+i+"";
        rs = ST.executeQuery(msg);
        if (rs.next() == true) {
          System.out.println("일정을 삭제합니다.");
          msg = "delete from f_seet_"+id+" where f_id ="+i+"";
          ST.executeUpdate(msg);
          f_view(id);
        }else {System.out.println("일정코드를 올바르게 입력해주세요.");}
      }
    }catch(Exception e) {}
  }

  public void f_view(String id) {
    System.out.println("완료 일정 목록을 출력합니다.");
    System.out.println();
    try{
      banner.printbanner2("완료 일정 목록");
      showtable.showFtable(id);

    }catch(Exception e) {System.out.println("완료일정이 없습니다.");}
  }
}



















