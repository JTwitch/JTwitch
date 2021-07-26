package com.twitch.socket;

import com.twitch.action.MessageAction;
import com.twitch.message.Message;
import com.twitch.socket.connection.ConnectionOption;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

class TwitchSocket extends WebSocketClient {

  private final ConnectionOption connectionOption;
  private final List<MessageAction> messageActions;
  private final ConnectedTwitchBot bot;

  public TwitchSocket(ConnectionOption connectionOption, List<MessageAction> messageActions, ConnectedTwitchBot bot) throws URISyntaxException {
    super(new URI(connectionOption.getConnectionUrl()));
    this.connectionOption = connectionOption;
    this.messageActions = messageActions;
    this.bot = bot;
  }

  @Override
  public void onOpen(ServerHandshake serverHandshake) {
    System.out.println("Websocket, Open ");
    send("PASS oauth:" + connectionOption.getToken());
    send("NICK "       + connectionOption.getUser());
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
  public void onClose(int i, String s, boolean b) {
    System.out.println("Websocket, Closed " + s);
  }

  @Override
  public void onError(Exception e) {
    System.out.println("Websocket, Error " + e.getMessage());
  }
}
