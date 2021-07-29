package com.twitch.command;

/**
 * This command allows you to set your room so only
 * users subscribed to you can talk in the chat room.
 * If you don't have the subscription feature it will
 * only allow the Broadcaster and the channel moderators
 * to talk in the chat room.
 */
record SubscribersCommand() implements Command {
  @Override
  public String getCommand() {
    return "/subscribers";
  }
}
