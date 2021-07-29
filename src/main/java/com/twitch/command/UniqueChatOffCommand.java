package com.twitch.command;

/**
 * This command will disable Uniquechat mode if
 * it was previously enabled on the channel.
 */
record UniqueChatOffCommand() implements Command {

  @Override
  public String getCommand() {
    return "/uniquechatoff";
  }
}
