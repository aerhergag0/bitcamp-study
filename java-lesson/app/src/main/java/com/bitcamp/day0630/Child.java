package com.bitcamp.day0630;

public class Child extends Father  { //다중 상속 할수 없음

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Child me = new Child();
    int a = me.bank(); // static에선 nonstatic 사용 불가능

  }

  public void book() {
    int m = bank();
  }

}
