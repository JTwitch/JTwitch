package com.twitch.socket;

import com.twitch.action.MessageAction;
import com.twitch.message.Message;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TwitchBot {

  private String botAccount;
  private String token;

  private TwitchSocket twitchSocket;
  private final List<MessageAction> messageActions = new ArrayList<>();

  public TwitchBot(String botAccount, String token) {
    this.botAccount = botAccount;
    this.token = token;
  }

  public TwitchBot withActionOnMessage(MessageAction messageAction) {
    messageActions.add(messageAction);
    return this;
  }

  public void connect() throws InterruptedException, URISyntaxException {
    twitchSocket = new TwitchSocket(botAccount, token, messageActions, this);
    twitchSocket.connectBlocking();
  }

  public void join(String streamer) {
    twitchSocket.send("JOIN #" + streamer);
  }

  public void send(String streamer, String message) {
    twitchSocket.send("PRIVMSG #" + streamer + " :"+message);
  }
}
