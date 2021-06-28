package com.eomcs;

class Calculator3 {
  static int result;

  static void plus(Calculator2 c, int value) {
    c.result += value;
  }
}
public class Test2 {
  public static void main(String[] args) {
    Calculator2 obj1 = new Calculator2();
    Calculator2.plus(obj1, 100);
    Calculator2.plus(obj1, 200);
    Calculator2.plus(obj1, 300);

    Calculator2 obj2 = new Calculator2();
    Calculator2.plus(obj2, 111);
    Calculator2.plus(obj2, 222);
    System.out.println(Calculator1.result);
  }
}