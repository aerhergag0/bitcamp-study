package com.bitcamp.day0701;

public class BitCamp_2 extends LA{
  public static void main(String[] args) {
    BitCamp_2 bc = new BitCamp_2();
    bc.book();
  }

  public void book() {
    System.out.println("book 몽블랑");
    cherry();
    this.cherry();
    super.cherry();

  }
  @Override
  public void cherry() {
    System.out.println("blue cherry");
  }
}
