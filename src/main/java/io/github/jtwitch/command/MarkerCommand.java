package io.github.jtwitch.command;

import lombok.SneakyThrows;

/**
 * Adds a stream marker (with an optional description, max 140 characters)
 * at the current timestamp.
 * You can use markers in the Highlighter for easier editing.
 */
record MarkerCommand(String description) implements Command {

  @Override
  @SneakyThrows
  public String getCommand() {
    control();
    return "/marker " + description;
  }

  private void control() throws TooLongException {
    if (description.length() > 140) {
      throw new TooLongException("a description can only be 140 character max");
    }
  }

  private static class TooLongException extends Exception {
    public TooLongException(String s) {
      super(s);
    }
  }
}
