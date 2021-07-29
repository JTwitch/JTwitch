package com.twitch.command.type;

public enum Unit {
  SECONDS("s", 7_862_400),
  MINUTES("m",   131_040),
  HOURS  ("h",     2_184),
  DAYS   ("d",        91),
  WEEK   ("w",        13),
  MOUNTH ("mo",        3);

  private final String format;
  private final int max;

  Unit(String format, int max) {
    this.format = format;
    this.max = max;
  }

  @Override
  public String toString() {
    return format;
  }

  public void control(int time) throws OutOfTimeException {
    if (time > max) {
      throw new OutOfTimeException(this.name() + " has max " + max);
    }
  }

  private static class OutOfTimeException extends Exception {
    public OutOfTimeException(String s) {
      super(s);
    }
  }
}
