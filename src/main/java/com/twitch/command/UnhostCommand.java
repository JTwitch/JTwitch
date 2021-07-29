package com.twitch.command;

/**
 * Using this command will revert the embedding from hosting a channel and return it to its normal state.
 */
record UnhostCommand() implements Command {
  @Override
  public String getCommand() {
    return "/unhost";
  }
}
