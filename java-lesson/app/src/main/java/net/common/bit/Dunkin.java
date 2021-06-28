package net.common.bit;

public class Dunkin {
  public String coffee(){ 
    //Non-static메소드, 리턴값
    //객체화생성후 객체명.coffee();
    String kind="아이스라떼";
    return kind;
  }//end

  public static  void donuts(int cnt){
    //static메소드 메소드(매개인자)
    System.out.println("도너츠 메소드 주문개수 " + cnt+ " 입니다.");
    //Dunkin.donuts(3);접근
  }//end

  public void menu() { //리턴값X, 매개인자X

  }//end
}//class END
