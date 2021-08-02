package io.github.jtwitch.socket;

import io.github.jtwitch.action.MessageAction;
import io.github.jtwitch.action.ScheduleAction;
import io.github.jtwitch.socket.connection.ConnectionOption;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a twitch bot before it is connected.
 */
public class TwitchBot {

  private final ConnectionOption option;
  private final List<MessageAction> messageActions = new ArrayList<>();
  private final List<ScheduleAction> scheduleActions = new ArrayList<>();

  /**
   * The only constructor.
   * @param botAccount the name of the bot account. for instance,
   *                   if your bot account is {@code nightbot}, the botAccount is {@code nightbot}
   * @param token the connection token the you generate <a href="https://twitchapps.com/tmi/">here</a>
   */
  public TwitchBot(String botAccount, String token) {
    this.option = new ConnectionOption(botAccount, token);
  }

  /**
   * trigger the socket to connect to the SSL connection of twitch
   * @return the {@link TwitchBot} builder with a secure connection.
   */
  public TwitchBot secureConnection() {
    option.secureConnection();
    return this;
  }

  /**
   * add an action triggered by a message
   * @param messageAction action triggered by a message
   * @return the {@link TwitchBot} builder
   */
  public TwitchBot withActionOnMessage(MessageAction messageAction) {
    messageActions.add(messageAction);
    return this;
  }

  /**
   * add an action
   * @param periodInSecond time when you trigger an action
   * @param action the schedule action
   * @return the {@link TwitchBot} builder
   */
  public TwitchBot withScheduleAction(int periodInSecond, ScheduleAction.Action action) {
    scheduleActions.add(new ScheduleAction(periodInSecond, action));
    return this;
  }

  /**
   * connect the bot to the twitch socket.
   * @return the {@link ConnectedTwitchBot} with all de configured action.
   * @throws InterruptedException if the socket connection stop
   * @throws URISyntaxException   if the socket change address
   */
  public ConnectedTwitchBot connect() throws InterruptedException, URISyntaxException {
    return new ConnectedTwitchBot(option, messageActions, scheduleActions);
  }
}
