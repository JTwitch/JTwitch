package com.twitch.command.type;

/**
 * Allows you to change the color of your username. Normal users can choose only between these color.
 */
public enum ColorName {
  BLUE("Blue"),
  CORAL("Coral"),
  DODGER_BLUE("DodgerBlue"),
  SPRING_GREEN("SpringGreen"),
  YELLOW_GREEN("YellowGreen"),
  GREEN("Green"),
  ORANGE_RED("OrangeRed"),
  RED("Red"),
  GOLDEN_ROD("GoldenRod"),
  HOT_PINK("HotPink"),
  CADET_BLUE("CadetBlue"),
  SEA_GREEN("SeaGreen"),
  CHOCOLATE("Chocolate"),
  BLUE_VIOLET("BlueViolet"),
  FIREBRICK("Firebrick");

  private final String color;

  ColorName(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return color;
  }
}
