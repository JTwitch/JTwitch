package com.twitch.command.type;

public enum When {
  HALF_MINUTE          (30),
  ONE_MINUTE           (60),
  ONE_MINUTE_AND_A_HALF(90),
  TWO_MINUTE           (120),
  TWO_MINUTE_AND_A_HALF(150),
  THREE_MINUTE         (180),
  ;

  private final int seconds;

  When(int seconds) {
    this.seconds = seconds;
  }

  @Override
  public String toString() {
    return Integer.toString(seconds);
  }
}
