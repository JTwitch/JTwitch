package com.twitch.command;

/**
 * This command allows you to set a limit on how often
 * users in the chat room are allowed to send messages (rate limiting).
 */
record SlowCommand(int seconds) implements Command {

  @Override
  public String getCommand() {
    return "/slow " + seconds;
  }
}
