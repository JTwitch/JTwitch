package io.github.jtwitch.action;

import io.github.jtwitch.message.Message;
import io.github.jtwitch.socket.ConnectedTwitchBot;
import io.github.jtwitch.socket.TwitchBot;

/**
 * Represent what to do when you are trigger by the chat message. <br />
 * It is used when you build a {@link TwitchBot} with method {@link TwitchBot#withActionOnMessage(MessageAction)}
 * <p/>
 * You can for instance send `Hello world` on each message with : <br/>
 * <code>
 * new TwitchBot(user, token).withActionOnMessage((bot, message) -> bot.send(message.getStreamerName(), "Hello World")
 * </code>
 */
@FunctionalInterface
public interface MessageAction {

  void execute(ConnectedTwitchBot bot, Message message);
}
