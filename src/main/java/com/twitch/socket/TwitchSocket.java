package com.twitch.socket;

import com.twitch.action.MessageAction;
import com.twitch.message.Message;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.List;

class TwitchSocket extends WebSocketClient {

  private static final String URL = "%s://irc-ws.chat.twitch.tv:%d/irc";

  private final String botAccount;
  private final String token;
  private final List<MessageAction> messageActions;
  private final ConnectedTwitchBot bot;


  public TwitchSocket(String botAccount, String token, List<MessageAction> messageActions, SecurityType securityType, ConnectedTwitchBot bot) throws URISyntaxException {
    super(new URI(String.format(URL, securityType.getExtention(), securityType.getPort())));
    this.botAccount = botAccount;
    this.token = token;
    this.messageActions = messageActions;
    this.bot = bot;
  }


  @Override
  public void onOpen(ServerHandshake serverHandshake) {
    System.out.println("Websocket, Open ");
    send("PASS oauth:"+ token);
    send("NICK " + botAccount);
    send("CAP REQ :twitch.tv/membership");
    send("CAP REQ :twitch.tv/tags");
    send("CAP REQ :twitch.tv/commands");

  }

  @Override
  public void onMessage(String message) {
    if (message.startsWith("PING")) {
      send("PONG");
    } else if (message.contains(" PRIVMSG ")) {
      messageActions.forEach(messageAction -> messageAction.execute(bot, new Message(message)));
    }
    System.err.println(message);
  }

  @Override
  public void onMessage(ByteBuffer bytes) {
    super.onMessage(bytes);
  }

  @Override
  public void onClose(int i, String s, boolean b) {
    System.out.println("Websocket, Closed " + s);
  }

  @Override
  public void onError(Exception e) {
    System.out.println("Websocket, Error " + e.getMessage());
  }
}
