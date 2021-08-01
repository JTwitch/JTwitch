package io.github.jtwitch.command;

/**
 * This command will allow you to demote an existing moderator back to viewer
 * status (removing their moderator abilities).
 */
record RemoveModeratorCommand(String user) implements Command {
  @Override
  public String getCommand() {
    return "/unmod " + user;
  }
}
