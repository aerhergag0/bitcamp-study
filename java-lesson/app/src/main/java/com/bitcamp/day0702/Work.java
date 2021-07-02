package com.bitcamp.day0702;

public class Work extends AAA {
  public void star() {Car c = new Car();
  Work a1 = new Work();
  AAA a2 = new AAA();
  c.my(this);
  }



  public static void main(String[] args) {
    Work a1 =new Work();
    a1.star();
  }
}

class AAA {
  void apple() {}
  void mac() {}
}

class Car {
  public void my(AAA k2) {
    System.out.println(k2);
    System.out.println("내차");
  }
}