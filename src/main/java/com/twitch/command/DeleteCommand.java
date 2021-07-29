package com.twitch.command;

/**
 * This command will delete the target message from the chat.
 */
record DeleteCommand(String messageId) implements Command {

  @Override
  public String getCommand() {
    return "/delete " + messageId;
  }
}
