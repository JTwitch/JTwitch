package io.github.jtwitch.command;

/**
 * This command will allow you to block all messages from a specific
 * user in chat and whispers if you do not wish to see their comments
 */
record UnblockCommand(String user) implements Command {

  @Override
  public String getCommand() {
    return "/unblock " + user;
  }
}
