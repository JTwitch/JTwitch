package com.twitch.command;

/**
 * This command will allow the Broadcaster
 * and chat moderators to completely wipe
 * the previous chat history.
 */
record ClearCommand() implements Command {
  @Override
  public String getCommand() {
    return "/clear";
  }
}
