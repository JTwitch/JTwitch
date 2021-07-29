package com.twitch.command;

/**
 * This command will send the viewer to another live channel.
 */
record RaidCommand(String channel) implements Command {
  @Override
  public String getCommand() {
    return "/raid " + channel;
  }
}
