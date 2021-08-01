package io.github.jtwitch.command;

/**
 * This command allows you to set your room so
 * only messages that are 100% emotes are allowed.
 */
record EmoteOnlyCommand() implements Command {
  @Override
  public String getCommand() {
    return "/emoteonly";
  }
}
