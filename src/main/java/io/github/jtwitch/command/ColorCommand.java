package io.github.jtwitch.command;

import io.github.jtwitch.command.type.ColorName;

/**
 * Allows you to change the color of your username.
 * Normal users can choose between Blue, Coral, DodgerBlue,
 * SpringGreen, YellowGreen, Green, OrangeRed, Red, GoldenRod,
 * HotPink, CadetBlue, SeaGreen, Chocolate, BlueViolet, and
 * Firebrick.
 * Twitch Turbo users can use any Hex value (i.e: #000000).
 */
class ColorCommand implements Command {

  private final String color;

  public ColorCommand(ColorName color) {
    this.color = color.toString();
  }

  public ColorCommand(String colorAsHexa) {
    this.color = colorAsHexa;
  }

  @Override
  public String getCommand() {
    return "/color " + color;
  }
}
