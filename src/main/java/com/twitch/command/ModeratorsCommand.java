package com.twitch.command;

/**
 * This command will display a list of all chat moderators for that specific channel.
 */
record ModeratorsCommand() implements Command {

  public String getCommand() {
    return "/mods";
  }
}
