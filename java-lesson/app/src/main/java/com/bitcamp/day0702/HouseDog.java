package com.bitcamp.day0702;

public class HouseDog extends Dog {
  public HouseDog(String name) {
    this.setName(name);
  }

  public void sleep() {
    System.out.println(this.name + " zzz in the house.");
  }

  public void sleep(int hour) {
    System.out.println(this.name + "zzz in the house for "+ hour +"hours");
  }

  public static void main(String[] args) {
    HouseDog dog = new HouseDog("happy");
    System.out.println(dog.name);
  }
}
