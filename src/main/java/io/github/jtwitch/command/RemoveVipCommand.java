package io.github.jtwitch.command;

/**
 * This command willl revoke VIP status from a user.
 */
record RemoveVipCommand(String user) implements Command {
  @Override
  public String getCommand() {
    return "/unvip " + user;
  }
}
