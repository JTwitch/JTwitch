package com.twitch.socket;

import com.twitch.action.MessageAction;
import com.twitch.action.ScheduleAction;
import com.twitch.socket.connection.ConnectionOption;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TwitchBot {

  private final ConnectionOption option;
  private final List<MessageAction> messageActions = new ArrayList<>();
  private final List<ScheduleAction> scheduleActions = new ArrayList<>();

  public TwitchBot(String botAccount, String token) {
    this.option = new ConnectionOption(botAccount, token);
  }

  /**
   * trigger the socket to connect to the SSL connection of twitch
   */
  public TwitchBot secureConnection() {
    option.secureConnection();
    return this;
  }

  public TwitchBot withActionOnMessage(MessageAction messageAction) {
    messageActions.add(messageAction);
    return this;
  }

  public TwitchBot withScheduleAction(int periodInSecond, ScheduleAction.Action action) {
    scheduleActions.add(new ScheduleAction(periodInSecond, action));
    return this;
  }

  public ConnectedTwitchBot connect() throws InterruptedException, URISyntaxException {
    return new ConnectedTwitchBot(option, messageActions, scheduleActions);
  }
}
