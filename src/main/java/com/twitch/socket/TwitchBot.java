package com.twitch.socket;

import com.twitch.action.MessageAction;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TwitchBot {

  private final String botAccount;
  private final String token;
  private SecurityType securityType = SecurityType.STANDARD_PROTOCOL;

  private final List<MessageAction> messageActions = new ArrayList<>();

  public TwitchBot(String botAccount, String token) {
    this.botAccount = botAccount;
    this.token = token;
  }

  /**
   * trigger the socket to connect to the SSL connection of twitch
   */
  public TwitchBot secureConnection() {
    securityType = SecurityType.SECURE_PROTOCOL;
    return this;
  }

  public TwitchBot withActionOnMessage(MessageAction messageAction) {
    messageActions.add(messageAction);
    return this;
  }

  public ConnectedTwitchBot connect() throws InterruptedException, URISyntaxException {
    return new ConnectedTwitchBot(botAccount, token, messageActions, securityType);
  }
}
