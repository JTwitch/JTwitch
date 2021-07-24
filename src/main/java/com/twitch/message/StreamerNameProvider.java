package com.twitch.message;

import java.util.function.Function;

/**
 * get The streamer name by parsing and filtering the socket message.
 */
class StreamerNameProvider implements Function<String, String> {

  @Override
  public String apply(final String message) {
    String socketMessage = ".tmi.twitch.tv PRIVMSG #";
    var userPart = message.substring(message.indexOf(socketMessage) + socketMessage.length());
    return userPart.split(" ")[0];
  }
}
