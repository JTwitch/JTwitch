package io.github.jtwitch.command;

/**
 * This command will simply disconnect you from the chat server. To reconnect, simply refresh the page.
 */
record DisconnectCommand() implements Command {

  public String getCommand() {
    return "/disconnect";
  }
}
