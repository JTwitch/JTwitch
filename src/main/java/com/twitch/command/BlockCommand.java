package com.twitch.command;

/**
 * This command will allow you to block all messages from a specific
 * user in chat and whispers if you do not wish to see their comments
 */
record BlockCommand(String user) implements Command {

  @Override
  public String getCommand() {
    return "/block " + user;
  }
}
