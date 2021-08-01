package io.github.jtwitch.command;

/**
 * This command will allow you to promote a user to a channel moderator
 * allowing them to have access to all of the above commands and features.
 */
record AddModeratorCommand(String user) implements Command {
  @Override
  public String getCommand() {
    return "/mod " + user;
  }
}
