package io.github.jtwitch.message;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * Represent a message sent by a user on twitch
 * to create an instance of it, you need to pass the twitch socket message version of it.
 */
@Getter
public class Message {

  private final String id;
  private final String userName;
  private final String streamerName;
  private final String messageContent;
  private final MessageType messageType;

  /**
   * @param socketMessage the message sent by twitch by socket.
   */
  public Message(String socketMessage) {
    id             = findMessageId(socketMessage);
    userName       = findUserName(socketMessage);
    streamerName   = findStreamerName(socketMessage);
    messageContent = findMessageContent(socketMessage);
    messageType = findTypeMessage(socketMessage);
  }

  private MessageType findTypeMessage(String socketMessage) {
    return MessageType.of(Stream.of(socketMessage.split(";"))
                                .filter(m -> m.startsWith("msg-id="))
                                .findFirst()
                                .map(m -> m.substring(7))
                                .orElse(null));
  }

  private String findMessageId(String socketMessage) {
    return Stream.of(socketMessage.split(";"))
                 .filter(m -> m.startsWith("id="))
                 .findFirst()
                 .map(m -> m.substring(3))
                 .orElse("");
  }

  private String findMessageContent(final String message) {
    var socketMessage = ".tmi.twitch.tv PRIVMSG #";
    var userPart = message.substring(message.indexOf(socketMessage) + socketMessage.length());
    return userPart.substring(userPart.indexOf(":")+1);
  }

  private String findStreamerName(final String message) {
    String socketMessage = ".tmi.twitch.tv PRIVMSG #";
    var userPart = message.substring(message.indexOf(socketMessage) + socketMessage.length());
    return userPart.split(" ")[0];
  }

  private String findUserName(final String message) {
    var userPart = message.substring(1, message.indexOf(".tmi.twitch.tv PRIVMSG #"));
    var user = userPart.split("!.*@");
    return user.length > 1 ? user[1] : user[0];
  }

  @Override
  public String toString() {
    return id + " | " + streamerName + " | " + userName + " | " + messageContent;
  }
}
