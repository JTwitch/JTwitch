package io.github.jtwitch.command;

record FollowersOffCommand() implements Command {
  @Override
  public String getCommand() {
    return "/followersoff";
  }
}
