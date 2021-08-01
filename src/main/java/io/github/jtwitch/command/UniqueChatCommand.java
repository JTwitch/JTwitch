package io.github.jtwitch.command;

/**
 * This command disallows users from posting non-unique
 * messages to the channel.
 * It will check for a minimum of 9 characters that are
 * not symbol unicode characters and then purges any repetitive
 * chat lines beyond that.
 *
 * Uniquechat is a unique way of moderating, which essentially
 * allowing you to stop generic copy-pasted messages intended as
 * spam among over generally annoying content.
 */
record UniqueChatCommand() implements Command {

  @Override
  public String getCommand() {
    return "/uniquechat";
  }
}
