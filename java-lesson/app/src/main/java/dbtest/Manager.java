package dbtest;

import java.sql.*;
import java.util.*;
import java.util.regex.*;

public class Manager{
  Scanner sc = new Scanner(System.in);
  String msg;
  ResultSet RS = null;
  boolean cheak = false;

  public void manager(){
    while(true) {
      System.out.println("\n관리자계정입니다. 1.회원수정 2.회원삭제 3.회원목록출력 0.로그아웃");
      String i = sc.nextLine(); // switch를 if로 바꿔주고
      if (i.equals("1")) {
        list();
        update();
      }
      else if (i.equals("2")) {
        list();
        delete();
      }
      else if (i.equals("3")) {
        list();
      }
      else if (i.equals("0")) {
        return;
      }else {
        System.out.println("올바른 번호를 입력해주세요");
      }
    }//switch 종료
  }//manager 종료


  public void update() {
    try { 
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();


      String del;
      String a;
      String b;
      loop:while(true) {
        System.out.println("1.이름 수정 2.PW 수정 3.이메일 수정 4.핸드폰 번호 수정 0.이전메뉴로");
        String i = sc.nextLine();

        switch(i) {
          case "1":
            while(true) {
              System.out.println("수정하실 회원의 ID 입력 뒤로가기 0");
              a = sc.nextLine();
              if(a.isEmpty()) {
                System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
              }
              if(a.equals("0")) {
                break;
              }
              msg = "select * from profile where id='"+a+"'";
              RS = ST.executeQuery(msg);
              if (RS.next() == false) {
                System.out.println("아이디가 존재하지 않습니다.");
              } else {
                msg = "select * from profile where id='"+a+"'";
                RS = ST.executeQuery(msg);
                while(true) {
                  System.out.print("바꾸실 이름을 입력해주세요");
                  b = sc.nextLine();
                  if(b.isEmpty()) {
                    continue;
                  }
                  if(b.equals("0")) {
                    break;
                  }
                  msg = "update profile set Name='"+b+"'where ID ='"+a+"'";
                  ST = CN.createStatement();
                  ST.executeUpdate(msg);
                  break;
                }break;
              }
            }break;


          case "2":
            while(true) {
              System.out.print("수정하실 회원의 ID 입력 뒤로가기 0 "+"\n");
              a = sc.nextLine();
              if(a.isEmpty()) {
                System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
              }
              if(a.equals("0")) {
                break;
              }
              msg = "select * from profile where id='"+a+"'";
              RS = ST.executeQuery(msg);
              if (RS.next() == false) {
                System.out.println("아이디가 존재하지 않습니다.");
                System.out.println("수정하실 회원의 ID 를 다시 입력 해주세요");
                continue;
              } else {
                msg = "select * from profile where id='"+a+"'";
                RS = ST.executeQuery(msg);
                while(true) {
                  System.out.print("바꾸실 비밀번호를 입력해주세요 뒤로가기 0");
                  b = sc.nextLine();
                  if(b.isEmpty()) {
                    System.out.println("비밀번호를 입력해주세요 뒤로가기 0"); continue;
                  }
                  if(b.equals("0")) {
                    break;
                  }
                  if (b.length() > 20 || b.length() < 8) {
                    System.out.println("변경하실 비밀번호를 최소 8자에서 최대 20자 사이로 입력해주세요.\n");
                    continue;
                  }
                  msg = "update profile set PW='"+b+"'where ID='"+a+"'";
                  ST = CN.createStatement();
                  ST.executeUpdate(msg);
                  System.out.println(a+"회원님의 비밀번호가 변경되었습니다");
                  break;                
                }
              }break;
            }break;





          case "3":
            System.out.print("수정하실 회원의 ID 입력 뒤로가기 0"+"\n");
            while(true) {
              a = sc.nextLine();
              if(a.equals("0")) {
                break;
              }
              if(a.isEmpty()) {
                System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
              }
              msg = "select * from profile where id='"+a+"'";
              RS = ST.executeQuery(msg);
              if (RS.next() == false) {
                System.out.println("아이디가 존재하지 않습니다.");
                System.out.println("수정하실 회원의 ID 입력 뒤로가기 0");
                continue;
              } else {
                msg = "select * from profile where id='"+a+"'";
                RS = ST.executeQuery(msg);
              }
              while(true) {
                System.out.print("바꾸실 이메일 주소를 입력해주세요 뒤로가기 0");
                b = sc.nextLine();
                if(b.isEmpty()) {
                  continue;
                }
                if(b.equals("0")) {
                  break;
                }
                cheak = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?",b);
                if(cheak == true) {
                  msg = "update profile set EMAIL='"+b+"'where ID ='"+a+"'";
                  ST = CN.createStatement();
                  ST.executeUpdate(msg);
                  System.out.println(a+"님의 이메일주소가 변경되었습니다.");
                  break;
                }else{System.out.println("유효하지 않은 이메일주소 입니다."); continue;}
              }break;
            }break;

          case "4":
            System.out.print("수정하실 회원의 ID 입력 뒤로가기 0"+"\n");
            while(true) {
              a = sc.nextLine();
              if(a.isEmpty()) {
                System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
              }
              if(a.equals("0")) {
                break;
              }

              msg = "select * from profile where id='"+a+"'";
              RS = ST.executeQuery(msg);
              if (RS.next() == false) {
                System.out.println("아이디가 존재하지 않습니다.");
                System.out.println("수정하실 회원의 ID 입력 뒤로가기 0");
                continue;
              } else {
                msg = "select * from profile where id='"+a+"'";
                RS = ST.executeQuery(msg);
              }
              while(true) {
                System.out.print("바꾸실 핸드폰 번호를 입력해주세요 뒤로가기 0");
                b = sc.nextLine();
                if(b.isEmpty()) {
                  System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
                }
                if(b.equals("0")) {
                  break;
                }
                cheak = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",b);
                if(cheak == false) {
                  System.out.println("유효하지 않은 핸드폰번호입니다. "); 
                  continue;
                }else{
                  msg = "update profile set PHONE='"+b+"'where ID ='"+a+"'";
                  ST = CN.createStatement();
                  ST.executeUpdate(msg);
                  break;
                }
              }break;
            } break;

          case "0" : System.out.println("관리자 수정 기능을 취소합니다");return; 
        }//switch문 종료
      }


    }catch(Exception ex) { }      
  }

  public void delete() {
    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      String del;

      while(true) {
        System.out.print("삭제할 회원의 ID를 입력해주세요 뒤로가기 0"); // 회원삭제시 테이블도 날려줘야함
        del = sc.nextLine();
        if(del.isEmpty()) {
          System.out.println("ID를 입력해주세요 뒤로가기 0"); continue;
        }
        if(del.equals("0")) {
          break;
        }
        msg = "select * from profile where id='"+del+"'";
        RS = ST.executeQuery(msg);
        if (RS.next() == false) {
          System.out.println("아이디가 존재하지 않습니다.");
        } else {
          msg = "delete from profile where id='"+del+"'";
          RS = ST.executeQuery(msg);
          msg = "drop table f_seet_"+del+"";
          ST.executeUpdate(msg); //삭제한 회원의 완료 테이블 삭제
          msg = "drop table seet_"+del+"";
          ST.executeUpdate(msg); //삭제한 회원의 개인 테이블 삭제
          msg = "drop table s_seet_"+del+"";
          ST.executeUpdate(msg); //삭제한 회원의 공유 테이블 삭제
          msg = "drop sequence seq_f_seet_"+del+"";
          ST.executeUpdate(msg); // 삭제한 회원의 완료 테이블 시퀀스삭제
          msg = "drop sequence seq_seet_"+del+"";
          ST.executeUpdate(msg);// 삭제한 회원의 개인 테이블 시퀀스삭제
          msg = "drop sequence seq_s_seet_"+del+"";
          ST.executeUpdate(msg);// 삭제한 회원의 공유 테이블 시퀀스삭제
          System.out.println(del + "회원님의 정보가 삭제되었습니다");
          break;
        }
      }list();

    }catch(Exception e) {}


  }//수정하는 update 메서드 삭제

  public void list() { 
    System.out.println("회원 목록을 출력합니다.");
    try{
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();
      ST = CN.createStatement();
      msg ="select * from profile";
      ResultSet rs = ST.executeQuery(msg);//executeQuery로 명령출력한다
      while(rs.next() == true) {

        String a = rs.getString("NAME");//이름

        String b = rs.getString("ID");//아디
        if(a.equals("관리자")||b.equals("admin")) {
          break;
        }
        String c = rs.getString("PW");//비번
        String d = rs.getString("EMAIL");//이메일
        String e = rs.getString("PHONE");//폰
        System.out.printf(String.format("%-10s",a));
        System.out.printf(String.format("%15s",b));
        System.out.printf(String.format("%20s",c));
        System.out.printf(String.format("%25s",d));
        System.out.printf(String.format("%20s",e));
        System.out.println();
      } //회원목록 출력해오기 이중 회원을 삭제 수정할수있음 수정은 특정회원의 이름 ,비밀번호 연락처 등 while 종료

    }catch(Exception e) {}
  }

}//manager 종료


