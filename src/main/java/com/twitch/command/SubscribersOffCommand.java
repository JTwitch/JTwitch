package com.twitch.command;

record SubscribersOffCommand() implements Command {
  @Override
  public String getCommand() {
    return "/subscribersoff";
  }
}
