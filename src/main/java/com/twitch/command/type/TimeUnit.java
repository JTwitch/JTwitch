package com.twitch.command.type;

import lombok.SneakyThrows;

public record TimeUnit(int time, Unit unit) {

  @Override
  @SneakyThrows
  public String toString() {
    unit.control(time);
    return time+unit.toString();
  }
}
