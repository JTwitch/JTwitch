package com.twitch.command;

/**
 * This command will allow you to permanently
 * ban a user from the chat room.
 */
record BanCommand(String user) implements Command {

  @Override
  public String getCommand() {
    return "/ban " + user;
  }
}
