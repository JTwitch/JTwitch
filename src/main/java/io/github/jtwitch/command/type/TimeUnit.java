package io.github.jtwitch.command.type;

import lombok.SneakyThrows;

/**
 * represent the time a user need to follow a streamer to write in a follower command
 * @see io.github.jtwitch.command.FollowersCommand
 */
public record TimeUnit(int time, Unit unit) {

  @Override
  @SneakyThrows
  public String toString() {
    unit.control(time);
    return time+unit.toString();
  }
}
