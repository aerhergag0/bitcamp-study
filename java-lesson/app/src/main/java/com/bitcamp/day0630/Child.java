package com.bitcamp.day0630;

public class Child extends Father  { //다중 상속 할수 없음

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Child me = new Child();
    Father ob = new Child();

    ob.car();
    me.car();

    int a = me.bank(); // static에선 nonstatic 사용 불가능

  }

  public void book() {
    super.car();
    this.car();
    int m = bank();
  }
  @Override
  public void car() {
    System.out.println("override");
  }


}
