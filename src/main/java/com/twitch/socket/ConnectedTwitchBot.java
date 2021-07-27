package com.twitch.socket;

import com.twitch.action.MessageAction;
import com.twitch.action.ScheduleAction;
import com.twitch.message.Message;
import com.twitch.socket.connection.ConnectionOption;

import java.net.URISyntaxException;
import java.util.List;

public class ConnectedTwitchBot {

  private final TwitchSocket twitchSocket;

  public ConnectedTwitchBot(ConnectionOption connectionOption, List<MessageAction> messageActions, List<ScheduleAction> scheduleActions) throws InterruptedException, URISyntaxException {
    twitchSocket = new TwitchSocket(connectionOption, messageActions, this);
    twitchSocket.connectBlocking();
    scheduleActions.forEach(scheduleAction -> scheduleAction.run(this));
  }

  /**
   * Join a streamer channel
   */
  public ConnectedTwitchBot join(String streamer) {
    twitchSocket.send("JOIN #" + streamer);
    return this;
  }

  /** Leave a streamer channel */
  public ConnectedTwitchBot leave(String streamer) {
    twitchSocket.send("PART #" + streamer);
    return this;
  }

  /** send a message to a specific channel. */
  public void send(String streamer, String message) {
    twitchSocket.send("PRIVMSG #" + streamer + " :" + message);
  }

  /** reply to a message. */
  public void answer(Message messageToAnswer, String message) {
    twitchSocket.send("@reply-parent-msg-id=" + messageToAnswer.getId() + " PRIVMSG #" + messageToAnswer.getStreamerName() + " :" + message);
  }

  public void whisper(String user, String message) {
    send("jtv", String.format("/w %s %s", user, message));
  }


  /** delete a message. */
  public void delete(Message message) {
    send(message.getStreamerName(), "/delete " + message.getId());
  }
}
