package io.github.jtwitch.command;

import io.github.jtwitch.command.type.When;

/**
 * An Affiliate and Partner command that runs a commercial for all of your viewers.
 */
record CommercialCommand(When when) implements Command {
  @Override
  public String getCommand() {
    return "/commercial " + when;
  }
}
