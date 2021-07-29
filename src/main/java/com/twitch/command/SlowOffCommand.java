package com.twitch.command;

/**
 * This command allows you to disable subscribers
 * only chat room if you previously enabled it.
 */
record SlowOffCommand() implements Command {

  @Override
  public String getCommand() {
    return "/slowoff";
  }
}
