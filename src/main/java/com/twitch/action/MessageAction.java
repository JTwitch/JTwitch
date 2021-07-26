package com.twitch.action;

import com.twitch.message.Message;
import com.twitch.socket.ConnectedTwitchBot;
import com.twitch.socket.TwitchBot;

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
