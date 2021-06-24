package com.eomcs;


import java.util.Date;
//01. main(): 프로그램 entry point
//02. 사용자로부터 명령어 입력 받기
//03. 사용자로부터 계속 명령어 입력 받기
//04. quit 명령어를 입력 받았을 때 반복 종료하기
//05. 명령어 별로 실행을 분기하기
//06. 게시글 입력 받기
//07. 배열을 이용하여 여러 개의 게시글 보관하기
//08. 상수(final 변수)를 이용하여 배열의 크기를 다루기
//09. 게시글 목록 출력하기
//10. 게시글 상세 조회
//11. 게시글 조회수 추가하기
//12. 게시글 등록일 추가하기
//13. 게시글 변경하기
//14. 게시글 삭제하기
//15. 메서드 문법을 이용하여 기능 별로 명령어를 묶어 관리하기
//16. 클래스를 이용하여 새 데이터타입을 정의하기
import java.util.Scanner;

public class App2 {

  static class Board {
    String title;
    String context;
    String comment;
    String viewcount;
    Date createdDate;
  }

  static final int BOARD_LENGTH = 5;
  static Board[] boards = new Board[BOARD_LENGTH];
  static int boardsize = 0;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("[게시판 관리]");
    System.out.println("======================");


    programloop : while( true ) {
      System.out.print("명령> ");

      String command = sc.nextLine();

      switch(command) {
        case "add" :   add();    break;
        case "list":   list();   break;
        case "update": update(); break;
        case "delete": delete(); break;
        case "view":   view();   break;
        case "quit" :
          break programloop;
        default:
          System.out.println("잘못된 명령어입니다.");
          break;
      }
    }
    sc.close();
    System.out.println("프로그램을 종료합니다.");
  }

  static void add() {
    System.out.println("======================");
    System.out.println("[게시판 등록]");
    System.out.println("======================");

    if(boardsize >= BOARD_LENGTH) {
      System.out.println("게시판을 더 이상 등록할 수 없습니다.");
      return;
    }
    Board board = new Board();

    System.out.print("제목 : ");
    board.title = sc.nextLine();
    System.out.print("내용 : ");
    board.context = sc.nextLine();
    System.out.print("주석 : ");
    board.comment = sc.nextLine();

    board.createdDate = new Date();

    boards[boardsize++] = board;
    System.out.println("게시물을 등록했습니다.");
  }

  static void list() {
    System.out.println("======================");
    System.out.println("[게시판 목록]");
    System.out.println("======================");

    for (int i=0 ; i<boardsize ; i++) {
      Board board = boards[i];
      System.out.printf("%d 번 : %s  \n",i,board.title);
    }
  }

  static void update() {
    System.out.println("======================");
    System.out.println("[게시판 수정]");
    System.out.println("======================");

    System.out.print("수정할 게시판 번호입력 : ");
    int index = Integer.parseInt(sc.nextLine());

    if(index < 0 || index >= boardsize) {
      System.out.println("유효하지 않은 숫자입니다.");
      return;    
    }
    Board board = boards[index];

    System.out.printf("제목(%s) -> \n", board.title);
    board.title = sc.nextLine();
    System.out.printf("내용(%s) -> \n", board.context);
    board.context = sc.nextLine();
    System.out.printf("주석(%s) -> \n", board.comment);
    board.comment = sc.nextLine();
    System.out.println("수정 완료");

  }

  static void delete() {
    System.out.println("======================");
    System.out.println("[게시판 삭제]");
    System.out.println("======================");

    System.out.print("삭제할 게시판 번호입력 : ");
    int index = Integer.parseInt(sc.nextLine());

    if(index < 0 || index >= boardsize) {
      System.out.println("유효하지 않은 숫자입니다.");
      return;
    }

    System.out.println("정말 삭제 하시겠습니까? (y/N) ");
    if(!sc.nextLine().equals("y")) {
      System.out.println("삭제를 취소하였습니다.");
      return;
    }

    for (int i = index ; i<boardsize-1 ; i++) {
      titles[i] = titles[i + 1];
      contexts[i] = contexts[i + 1];
      comments[i] = comments[i + 1];
      createdDates[i] = createdDates[i + 1];
      viewcounts[i] = viewcounts[i + 1];
    }
    boardsize--;
    System.out.println("삭제 완료되었습니다.");
  }

  static void view() {
    System.out.println("======================");
    System.out.println("[게시판 보기]");
    System.out.println("======================");

    System.out.print("조회할 게시판 번호입력 : ");
    int index = Integer.parseInt(sc.nextLine());

    if(index < 0 || index >= boardsize) {
      System.out.println("유효하지 않은 숫자입니다.");
      return;
    }
    viewcounts[index]++;
    System.out.printf("%d 번 게시판\n",index);
    System.out.printf("제목 : %s\n", titles[index]);
    System.out.printf("내용 : %s\n", contexts[index]);
    System.out.printf("주석 : %s\n", comments[index]);
    System.out.printf("생성날짜 : %1$tY - %1$tm - %1$td  %1$tH : %1$tM : %1$tS\n", createdDates[index]);
    System.out.printf("조회수 : %d\n", viewcounts[index]);

  }
}
