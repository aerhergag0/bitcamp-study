package com.bitcamp.day0628;

public class Lotto { //단독실행x
  public int[] input() {
    int[] su = new int[6]; // 전역변수로 바꾸지말것
    su[0] = 39; su[1] = 45; su[2] = 1; 
    su[3] = 17; su[4] = 9; su[5] = 27;

    return su;
  }

  public void output(int[] LT) {
    for(int i=0; i<LT.length ; i++) {
      System.out.println(LT[i]);
    }
    System.out.println("로또배열 출력");
  }

  public int inputHap() {
    int hap=0;
    int[] su = new int[6]; // 전역변수로 바꾸지말것
    su[0] = 39; su[1] = 45; su[2] = 1; 
    su[3] = 17; su[4] = 9; su[5] = 27;
    for (int i=0; i<su.length; i++) {
      hap += su[i];
    }
    return hap;
  }
}
