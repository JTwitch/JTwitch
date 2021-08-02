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

  /**
   * constructor with all
   * @param connectionOption      the credention
   * @param messageActions        all the message action
   * @param scheduleActions       all the schedule action when the bot is on
   * @throws InterruptedException if the socket connection stop
   * @throws URISyntaxException   if the socket change address
   */
  public ConnectedTwitchBot(ConnectionOption connectionOption, List<MessageAction> messageActions, List<ScheduleAction> scheduleActions) throws InterruptedException, URISyntaxException {
    twitchSocket = new TwitchSocket(connectionOption, messageActions, this);
    twitchSocket.connectBlocking();
    scheduleActions.forEach(scheduleAction -> scheduleAction.run(this));
  }

  /**
   * Join a streamer channel.
   * @param streamer the channel to join
   * @return itself
   */
  public ConnectedTwitchBot join(String streamer) {
    sendRawSocketMessage("JOIN #" + streamer);
    return this;
  }

  /**
   * Leave a streamer channel
   * @param streamer the channel to quit
   * @return itself
   */
  public ConnectedTwitchBot leave(String streamer) {
    sendRawSocketMessage("PART #" + streamer);
    return this;
  }

  /**
   * send a message to a specific channel.
   * @param streamer the channel to send a message
   * @param message the message to send
   */
  public void send(String streamer, String message) {
    sendRawSocketMessage("PRIVMSG #" + streamer + " :" + message);
  }

  /**
   * reply to a message.
   * @param messageToAnswer the targeted message to answer
   * @param message the message to send
   */
  public void answer(Message messageToAnswer, String message) {
    sendRawSocketMessage("@reply-parent-msg-id=" + messageToAnswer.getId() + " PRIVMSG #" + messageToAnswer.getStreamerName() + " :" + message);
  }

  /**
   * This command sends a private message to another user on Twitch.
   * @param user the targeted user to whisper
   * @param message the message to whisper
   */
  public void whisper(String user, String message) {
    command("jtv", Commands.whisper(user, message));
  }

  /**
   * Mention a specific user on a specific channel.
   * @param user the user to mention
   * @param streamer the channel where to mention it
   * @param message the message
   */
  public void mention(String user, String streamer, String message) {
    command(streamer, Commands.mention(user, message));
  }

  /**
   * send command to a specific channel.
   * You need to use {@link Commands} repository.
   * @param streamer the channel where to send the command
   * @param command the command to send. it can be find by {@link Commands}
   */
  public void command(String streamer, Command command) {
    send(streamer, command.getCommand());
  }

  /**
   * delete a message.
   * @param message the targeted message to delete
   */
  public void delete(Message message) {
    command(message.getStreamerName(), Commands.delete(message));
  }

  /**
   * send a raw command to the socket. <br/>
   * <b>Warning : Use this command only if a specific command does not exist in the wrapper.</b>
   * @param message the raw socket message
   */
  public void sendRawSocketMessage(String message) {
    twitchSocket.send(message);
  }
}
