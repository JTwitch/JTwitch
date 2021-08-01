package io.github.jtwitch.command;

/**
 * This command will allow you to host another channel on yours (embedded video player).
 */
record HostCommand(String channel) implements Command {
  @Override
  public String getCommand() {
    return "/host " + channel;
  }
}
