package schedule;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;

public class ShowCalendar {

  public void CalulateCalendar(int input_year, int input_month, int input_day) {
    try {
      Calendar cal = Calendar.getInstance();
      Boot boot = new Boot();
      Connection CN = boot.boot();
      Statement ST = CN.createStatement();

      cal.set(input_year,input_month-1,input_day);
      System.out.printf("%d 년 %d 월\n", cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1);
      System.out.println();

      System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
      int cnt = 0;
      int day_first = cal.get(Calendar.DAY_OF_WEEK);
      int day_last = cal.getActualMaximum(Calendar.DATE);
      for(int i=1; i<day_first; i++) {
        System.out.print("\t");
        cnt++;
      }
      for(int i=1; i<=day_last; i++) {
        if(cnt%7 ==0) {
          System.out.println();
        }
        cnt++;
        System.out.print(i+"\t");
      }
    } catch(Exception e) {} 
  }


  //임시main
  public static void main(String[] args) {
    ShowCalendar sc = new ShowCalendar();
    sc.CalulateCalendar(2021,7, 15);

  }
}
