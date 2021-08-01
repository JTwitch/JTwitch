package io.github.jtwitch.command;

/**
 * This command allows you to disable emote only mode
 * if you previously enabled it.
 */
record EmoteOnlyOffCommand() implements Command {
  @Override
  public String getCommand() {
    return "/emoteonlyoff";
  }
}
