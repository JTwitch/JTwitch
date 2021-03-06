package io.github.jtwitch.action;

import io.github.jtwitch.socket.ConnectedTwitchBot;
import io.github.jtwitch.socket.TwitchBot;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Represent what to on a specific time. <br />
 * It is used when you build a {@link TwitchBot} with method {@link TwitchBot#withScheduleAction(int, Action)}.
 * <br/>
 * You can for instance send `Hello world` all 5 minutes with : <br/>
 * <code>
 * new TwitchBot(user, token).withScheduleAction(300, bot -> bot.send("streamerName", "Hello World")
 * </code>
 */
public record ScheduleAction(int periodInSecond, Action action) {

  /**
   * run a schedule action.
   * @param bot the bot when it is connected to the twitch socket
   */
  public void run(ConnectedTwitchBot bot) {
    TimerTask tasknew = new TimerTask() {
      @Override
      public void run() {
        action.execute(bot);
      }
    };
    Timer timer = new Timer();
    long milliseconds = periodInSecond * 1000L;
    timer.schedule(tasknew, milliseconds, milliseconds);
  }

  /**
   * the action to be scheduled.
   */
  @FunctionalInterface
  public interface Action {

    /**
     * execute the action to be scheduled.
     * @param bot the bot when it is connected to the twitch socket
     */
    void execute(ConnectedTwitchBot bot);
  }
}
