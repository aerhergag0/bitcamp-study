package com.bitcamp.day0702;

public class Game { //Game.java , Game.class 생성
  public static void main(String[] args) {
    System.out.println("Game 클래스 main");
  }

  public class MyExit{}  // Game$MyExit.class , MyExit.java (생성x)
}
// public class Terran {}  Terran.java 생성X , Terran.class

class Zerg{} // Zerg.java x Zerg.class