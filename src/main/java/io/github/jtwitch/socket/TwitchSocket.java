package io.github.jtwitch.socket;

import io.github.jtwitch.action.MessageAction;
import io.github.jtwitch.message.Message;
import io.github.jtwitch.socket.connection.ConnectionOption;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Represent the twitch connection protocol.
 */
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
    send("NICK " + connectionOption.getUser());
    send("CAP REQ :twitch.tv/membership");
    send("CAP REQ :twitch.tv/tags");
    send("CAP REQ :twitch.tv/commands");
  }

  @Override
  public void onMessage(String message) {
    SocketMessage.process(this, message);
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

  private void executeMessageActions(String message) {
    messageActions.forEach(messageAction -> messageAction.execute(bot, new Message(message)));
  }

  private enum SocketMessage {
    PING   (message -> message.startsWith("PING"),    (socket, message) -> socket.send("PONG")),
    PRIVMSG(message -> message.contains(" PRIVMSG "), TwitchSocket::executeMessageActions),
    WHISPER(message -> message.contains(" WHISPER "), (socket, message) -> {}),
    ;

    private final Predicate<String> socketMessageType;
    private final BiConsumer<TwitchSocket, String> actions;

    SocketMessage(Predicate<String> socketMessageType, BiConsumer<TwitchSocket, String> actions) {
      this.socketMessageType = socketMessageType;
      this.actions = actions;
    }

    static void process(TwitchSocket socket, String message) {
      Stream.of(values())
            .filter(socketMessage -> socketMessage.socketMessageType.test(message))
            .forEach(socketMessage -> socketMessage.actions.accept(socket, message));
    }
  }
}
