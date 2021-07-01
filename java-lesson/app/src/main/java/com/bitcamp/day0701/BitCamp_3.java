package com.bitcamp.day0701;

public class BitCamp_3 {

  public BitCamp_3() {}
  public BitCamp_3(String location) {}
  public BitCamp_3(int floor) {}


  public static void main(String[] args) {
    BitCamp_3 bc = new BitCamp_3(7);
    bc.coffee();
  }

  public void coffee() {
    System.out.println("coffee 맥심카누");
    this.cookie(); //this생략가능
  }

  public void cookie() {
    System.out.println("cookie 버터링");
  }
}
