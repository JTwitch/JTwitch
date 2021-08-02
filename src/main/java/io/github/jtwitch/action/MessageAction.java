package io.github.jtwitch.action;

import io.github.jtwitch.message.Message;
import io.github.jtwitch.socket.ConnectedTwitchBot;
import io.github.jtwitch.socket.TwitchBot;

/**
 * Represent what to do when you are trigger by the chat message. <br />
 * It is used when you build a {@link TwitchBot} with method {@link TwitchBot#withActionOnMessage(MessageAction)}
 * <br/>
 * You can for instance send `Hello world` on each message with : <br/>
 * <code>
 * new TwitchBot(user, token).withActionOnMessage((bot, message) -> bot.send(message.getStreamerName(), "Hello World")
 * </code>
 */
@FunctionalInterface
public interface MessageAction {

  /**
   * execute something to do on the last message on the twitch chat.
   *
   * @param bot the bot when it is connected to the twitch socket
   * @param message the last message of the twitch chat
   */
  void execute(ConnectedTwitchBot bot, Message message);
}
