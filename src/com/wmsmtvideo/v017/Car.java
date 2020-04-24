package com.wmsmtvideo.v017;

import java.util.StringJoiner;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")

public class Car {
  private static final int DEFAULT_POWER = 100;
  private static final boolean DEFAULT_CONVERTIBLE = false;

  private String model;
  private int power;
  private boolean convertible;

  Car(final String model) {
    this(model, DEFAULT_POWER, DEFAULT_CONVERTIBLE);
  }

  Car(final String model, final int power) {
    this(model, power, DEFAULT_CONVERTIBLE);
  }

  Car(final String model, final int power, final boolean convertible) {
    String error = "";

    if (!isValidModel(model)) {
      error += getModelExceptionMessage();
    }

    if (!isValidPower(power)) {
      error += getPowerExceptionMessage(power);
    }

    if (!error.isEmpty()) {
      throw new IllegalArgumentException(error);
    }

    this.model = model;
    this.power = power;
    this.convertible = convertible;
  }

  public String getModel() {
    return model;
  }

  public void setModel(final String model) {
    if (!isValidModel(model)) {
      throw new IllegalArgumentException(getModelExceptionMessage());
    }

    this.model = model;
  }

  public int getPower() {
    return power;
  }

  public void setPower(final int power) {
    if (!isValidPower(power)) {
      throw new IllegalArgumentException(getPowerExceptionMessage(power));
    }
    this.power = power;
  }

  public boolean isConvertible() {
    return convertible;
  }

  public void setConvertible(final boolean convertible) {
    this.convertible = convertible;
  }


  private boolean isValidModel(final String value) {
    return value != null && !"".equals(value);
  }

  private String getModelExceptionMessage() {
    return "Modellname darf nicht leer sein\n";
  }

  private boolean isValidPower(final int value) {
    return value >= 0;
  }

  private String getPowerExceptionMessage(final int value) {
    return "Die Leistung darf nicht negativ sein (Ist: " + value + ")\n";
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "[", "]")
        .add("Model: " + model)
        .add("Leistung: " + power)
        .add("Kabrio: " + convertible)
        .toString();
  }


}


/*
@startuml
class Car {
- {static} DEFAULT_POWER : int = 100;
- {static} DEFAULT_CONVERTIBLE : boolean = false;
- model : String {notNull, notEmpty}
- power : int {>0}
- convertible : boolean
--
+ Car(String)
+ Car(String, int)
+ Car(String, int, boolean)
--
+ getModel() : String
+ setModel(String)
+ getPower() : int
+ setPower(int)
+ isConvertible() : boolean
+ setConvertible(boolean)
--
- isValidModel(String) : boolean
- getModelExceptionMessage() : String
- isValidPower(int) : boolean
- getPowerExceptionMessage(int) : String
}
@enduml
 */
