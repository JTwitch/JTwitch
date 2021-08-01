package io.github.jtwitch.command;

/**
 * This command will allow you to lift a permanent ban
 * on a user from the chat room.
 * You can also use this command to end a ban early;
 * this also applies to timeouts.
 */
record UnbanCommand(String user) implements Command {

  @Override
  public String getCommand() {
    return "/unban " + user;
  }
}
