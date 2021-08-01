package io.github.jtwitch.command;

/**
 * This command will remove the colon that typically appears
 * after your chat name and italicize your message text.
 * Can be used to denote action in the third-person.
 */
record MeCommand(String text) implements Command {

  @Override
  public String getCommand() {
    return "/me " + text;
  }
}
