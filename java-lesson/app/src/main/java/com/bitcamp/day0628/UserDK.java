package com.bitcamp.day0628;

import net.common.bit.Dunkin;

public class UserDK {
  public static void main(String[] args) {
    Dunkin dk = new Dunkin();
    String msg = dk.coffee();

    System.out.println("UserDK클래스 3:40");
    dk.donuts(3);
    System.out.println("주문한음료는 "+msg+" 입니다.");
  }
}
