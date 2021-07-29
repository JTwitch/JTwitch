package com.twitch.command;

/**
 * This command will grant VIP status to a user.
 */
record AddVipCommand(String user) implements Command {
  @Override
  public String getCommand() {
    return "/vip " + user;
  }
}
