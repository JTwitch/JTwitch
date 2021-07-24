package com.twitch.action;

import com.twitch.message.Message;
import com.twitch.socket.TwitchBot;

@FunctionalInterface
public interface MessageAction {

  void execute(TwitchBot bot, Message message);
}
