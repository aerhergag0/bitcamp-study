package com.bitcamp.day0628;

public class LottoUser {
  public static void main(String[] args) {
    System.out.println("LottoUser.java 10:08");
    Lotto my = new Lotto();
    int ret[] = my.input();
    my.output(ret);
    System.out.println("-------");
    my.inputHap();
    System.out.println("-------");
    int value = my.inputHap();
    System.out.println("숫자합계 =" + value);
    System.out.println("숫자합계 =" + my.inputHap());

    System.out.println("LottoUser 11:00");
  }
}
