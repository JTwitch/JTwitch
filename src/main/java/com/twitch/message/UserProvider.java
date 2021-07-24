package com.twitch.message;

import java.util.function.Function;

/**
 * get The user sending a message by parsing and filtering the socket message.
 */
class UserProvider implements Function<String, String> {

  @Override
  public String apply(final String message) {
    var userPart = message.substring(1, message.indexOf(".tmi.twitch.tv PRIVMSG #"));
    var user = userPart.split("!.*@");
    return user.length > 1 ? user[1] : user[0];
  }
}
