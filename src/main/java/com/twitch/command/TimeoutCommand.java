package com.twitch.command;

/**
 * This command allows you to temporarily ban someone
 * from the chat room for 10 minutes by default.
 * This will be indicated to yourself and the temporarily
 * banned subject in chat on a successful temporary ban.
 * A new timeout command will overwrite an old one.
 *
 * The command also supports banning for a specific set of
 * time via the optional [SECONDS] value.
 *
 * To clear a timeout, either use the Unban command or overwrite the current timeout with a new, 1-second one.
 */
record TimeoutCommand(String user, Integer second) implements Command {

  private String getSecond() {
    return second == null ? "" : Integer.toString(second);
  }

  @Override
  public String getCommand() {
    return "/timeout " + user + " " + getSecond();
  }
}
