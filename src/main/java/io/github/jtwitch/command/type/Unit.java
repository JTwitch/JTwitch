package io.github.jtwitch.command.type;

/**
 * Represent the unit time that a user need to follow a streamer to write in a follower command
 */
public enum Unit {
  /** time that a user need to follow a streamer to write in a follower command in seconds */
  SECONDS("s", 7_862_400),
  /** time that a user need to follow a streamer to write in a follower command in minutes */
  MINUTES("m",   131_040),
  /** time that a user need to follow a streamer to write in a follower command in hours */
  HOURS  ("h",     2_184),
  /** time that a user need to follow a streamer to write in a follower command in days */
  DAYS   ("d",        91),
  /** time that a user need to follow a streamer to write in a follower command in week */
  WEEK   ("w",        13),
  /** time that a user need to follow a streamer to write in a follower command in months */
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

  /**
   * control time validity
   * @param time the unit time
   * @throws OutOfTimeException if you try to insert to much (like 4 months)
   */
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
