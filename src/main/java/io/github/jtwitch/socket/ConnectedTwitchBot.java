package io.github.jtwitch.socket;

import io.github.jtwitch.action.MessageAction;
import io.github.jtwitch.action.ScheduleAction;
import io.github.jtwitch.command.Command;
import io.github.jtwitch.command.Commands;
import io.github.jtwitch.message.Message;
import io.github.jtwitch.socket.connection.ConnectionOption;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Represent a Twitch bos when it is connected.
 * Before it is connected, you can't join a channel or send a message.<br/>
 * To create a connection you need to use {@link TwitchBot#connect()}.
 */
public class ConnectedTwitchBot {

  private final TwitchSocket twitchSocket;

  public ConnectedTwitchBot(ConnectionOption connectionOption, List<MessageAction> messageActions, List<ScheduleAction> scheduleActions) throws InterruptedException, URISyntaxException {
    twitchSocket = new TwitchSocket(connectionOption, messageActions, this);
    twitchSocket.connectBlocking();
    scheduleActions.forEach(scheduleAction -> scheduleAction.run(this));
  }

  /**
   * Join a streamer channel.
   */
  public ConnectedTwitchBot join(String streamer) {
    sendRawSocketMessage("JOIN #" + streamer);
    return this;
  }

  /**
   * Leave a streamer channel
   */
  public ConnectedTwitchBot leave(String streamer) {
    sendRawSocketMessage("PART #" + streamer);
    return this;
  }

  /**
   * send a message to a specific channel.
   */
  public void send(String streamer, String message) {
    sendRawSocketMessage("PRIVMSG #" + streamer + " :" + message);
  }

  /**
   * reply to a message.
   */
  public void answer(Message messageToAnswer, String message) {
    sendRawSocketMessage("@reply-parent-msg-id=" + messageToAnswer.getId() + " PRIVMSG #" + messageToAnswer.getStreamerName() + " :" + message);
  }

  /** This command sends a private message to another user on Twitch. */
  public void whisper(String user, String message) {
    command("jtv", Commands.whisper(user, message));
  }

  /**
   * Mention a specific user on a specific channel.
   */
  public void mention(String user, String streamer, String message) {
    command(streamer, Commands.mention(user, message));
  }

  /**
   * send command to a specific channel.
   * You need to use {@link Commands} repository.
   */
  public void command(String streamer, Command command) {
    send(streamer, command.getCommand());
  }

  /** delete a message. */
  public void delete(Message message) {
    command(message.getStreamerName(), Commands.delete(message));
  }

  /**
   * send a raw command to the socket. <br/>
   * <b>⚠️ Use this command only if a specific command does not exist in the wrapper.</b>
   */
  public void sendRawSocketMessage(String message) {
    twitchSocket.send(message);
  }
}
