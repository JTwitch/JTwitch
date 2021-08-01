package io.github.jtwitch.command;

/**
 * This command will display a list of VIPs for that specific channel.
 */
record VipsCommand() implements Command {

  @Override
  public String getCommand() {
    return "/vips";
  }
}
