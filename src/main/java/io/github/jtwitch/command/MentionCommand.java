package io.github.jtwitch.command;

/**
 * This command will allow you to target your message at a user,
 * or reply directly to a specific message they’ve posted in the chat.
 */
record MentionCommand(String user, String message) implements Command {

  @Override
  public String getCommand() {
    return "@" + user + " " + message;
  }
}
