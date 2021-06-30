package com.bitcamp.day0628;

public class TestNote {
  public static void main(String[] args) {
    System.out.println("이지웅 9:42");
    System.out.println("이지웅2 9:43");
    TestNote tn = new TestNote();
    tn.note();

  }

  public String book() {
    String my = "책"; //local variable 
    return my;
  }

  public int price() {
    int money = 2700;
    return money;
  }

  public void note() {
    String title = book();
    System.out.println("책제목=" + title);
    System.out.println("책제목=" + book());
    System.out.println("책가격 = "+ price());
  }

}
