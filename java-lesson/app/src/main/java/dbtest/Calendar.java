package dbtest;

import java.util.Scanner;

public class Calendar {
  Scanner sc = new Scanner(System.in);
  static int input_year = 0;
  static int input_month = 0;
  public void cal_menu() {

  }

  public void cal_print(int y, int m) {
    for(int i=1583; i<y; i++) {
      if
    }

    int first = 0;

    System.out.println(" Sun\tMon\tTue\tWed\tThu\tFri\tSat");


  }

  public boolean cal_checkyear(int y) {
    if((y%4==0 && y%100==0) || y%400==0) {
      return true;
    }
    else
      return false;

  }

  public int cal_monthtoDay(int y,int m) {
    if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
      return 31;
    }
    else if (m==4 || m==6 || m==9 || m==11) {
      return 30;
    }
    else
      if(cal_checkyear(y)==true) {
        return 29;
      }
      else
        return 28;
  }

  public void cal_calculate() {

  }

  //연도,달 입력받기
  public void cal_input() {
    loop : while ( true ) {
      System.out.println("연도 : ");
      input_year = Integer.parseInt(sc.nextLine());
      if(input_year<0) {
        System.out.println("잘못된 값입니다");
        continue;
      }
      System.out.println("달 : ");
      input_month = Integer.parseInt(sc.nextLine());
      if(input_month>12 || input_month <1) {
        System.out.println("잘못된 값입니다. 1~12값입력");
      }
      else
        break loop;
    }
  }

  //임시 main
  public static void main(String[] args) {
    Calendar calendar = new Calendar();
    calendar.cal_input();
  }
}
