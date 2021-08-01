package io.github.jtwitch.command;

/**
 * This command sends a private message to another user on Twitch.
 */
record WhisperCommand(String user, String message) implements Command {

  @Override
  public String getCommand() {
    return String.format("/w %s %s", user, message);
  }
}
