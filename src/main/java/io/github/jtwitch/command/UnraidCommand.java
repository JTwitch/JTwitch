package io.github.jtwitch.command;

/**
 * This command will cancel the raid.
 */
record UnraidCommand() implements Command {

  @Override
  public String getCommand() {
    return "/unraid";
  }
}
