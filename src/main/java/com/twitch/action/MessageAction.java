package com.twitch.action;

import com.twitch.message.Message;
import com.twitch.socket.ConnectedTwitchBot;

@FunctionalInterface
public interface MessageAction {

  void execute(ConnectedTwitchBot bot, Message message);
}
