package com.twitch.message;

import lombok.Getter;

@Getter
public class Message {

  private final String userName;
  private final String streamerName;
  private final String messageContent;

  public Message(String socketMessage) {
    userName       = new UserProvider().apply(socketMessage);
    streamerName   = new StreamerNameProvider().apply(socketMessage);
    messageContent = new MessageContentProvider().apply(socketMessage);
  }

  @Override
  public String toString() {
    return streamerName + " | " + userName + " | " + messageContent;
  }
}
