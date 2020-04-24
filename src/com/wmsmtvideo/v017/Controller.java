package com.wmsmtvideo.v017;

public class Controller {

  public void start() {
    Car mercedes = new Car("A120");
    Car hyundai = new Car("ix20", 60);
    Car vw = new Car("Golf Kabrio", 100, true);

    System.out.println(mercedes);
    System.out.println(hyundai);
    System.out.println(vw);

    try {
      Car whatever = new Car("Whatever", -33);
    } catch (IllegalArgumentException exc) {
      System.out.println(exc.getLocalizedMessage());
      System.out.println("Das Programm wird beendet\n");
      System.exit(1);
    }

  }

}
