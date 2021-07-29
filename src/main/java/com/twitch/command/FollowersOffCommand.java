package com.twitch.command;

record FollowersOffCommand() implements Command {
  @Override
  public String getCommand() {
    return "/followersoff";
  }
}
