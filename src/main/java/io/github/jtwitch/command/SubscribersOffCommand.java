package io.github.jtwitch.command;

record SubscribersOffCommand() implements Command {
  @Override
  public String getCommand() {
    return "/subscribersoff";
  }
}
