package com.twitch.command;

import com.twitch.command.type.ColorName;
import com.twitch.command.type.TimeUnit;
import com.twitch.command.type.When;
import com.twitch.message.Message;

/**
 * Repository of all possible {@link Command}.
 */
public final class Commands {

  private Commands() throws IllegalAccessException {
    throw new IllegalAccessException("connot be instanciate");
  }

  /**
   * This command will display a list of all chat moderators for that specific channel.
   */
  public static Command moderators() {
    return new ModeratorsCommand();
  }

  /**
   * This command will display a list of VIPs for that specific channel.
   */
  public static Command vips() {
    return new VipsCommand();
  }

  /**
   * Allows you to change the color of your username.
   * Normal users can choose between Blue, Coral, DodgerBlue,
   * SpringGreen, YellowGreen, Green, OrangeRed, Red, GoldenRod,
   * HotPink, CadetBlue, SeaGreen, Chocolate, BlueViolet, and
   * Firebrick.
   */
  public static Command color(ColorName colorName) {
    return new ColorCommand(colorName);
  }

  /**
   * Allows you to change the color of your username.
   * Twitch Turbo users can use any Hex value (i.e: #000000).
   */
  public static Command color(String hexa) {
    return new ColorCommand(hexa);
  }

  /**
   * This command will allow you to block all messages from a specific
   * user in chat and whispers if you do not wish to see their comments
   */
  public static Command block(String user) {
    return new BlockCommand(user);
  }

  /**
   * This command will allow you to block all messages from a specific
   * user in chat and whispers if you do not wish to see their comments
   */
  public static Command unblock(String user) {
    return new UnblockCommand(user);
  }

  /**
   * This command will remove the colon that typically appears
   * after your chat name and italicize your message text.
   * Can be used to denote action in the third-person.
   */
  public static Command me(String text) {
    return new MeCommand(text);
  }

  /**
   * This command will simply disconnect you from the chat server.
   * To reconnect, simply refresh the page.
   */
  public static Command disconnect() {
    return new DisconnectCommand();
  }

  /**
   * This command sends a private message to another user on Twitch.
   */
  public static Command whisper(String user, String message) {
    return new WhisperCommand(user, message);
  }

  /**
   * This command will allow you to target your message at a user,
   * or reply directly to a specific message they’ve posted in the chat.
   */
  public static Command mention(String user, String message) {
    return new MentionCommand(user, message);
  }

  /**
   * This command will delete the target message from the chat.
   */
  public static Command delete(Message message) {
    return new DeleteCommand(message.getId());
  }

  /**
   * This command will delete the target message from the chat.
   */
  public static Command delete(String messageId) {
    return new DeleteCommand(messageId);
  }

  /**
   * This command allows you to temporarily ban someone
   * from the chat room for 10 minutes by default.
   * This will be indicated to yourself and the temporarily
   * banned subject in chat on a successful temporary ban.
   * A new timeout command will overwrite an old one.
   * <p>
   * The command also supports banning for a specific set of
   * time via the optional [SECONDS] value.
   * <p>
   * To clear a timeout, either use the Unban command or overwrite the current timeout with a new, 1-second one.
   */
  public static Command timeout(String user, Integer second) {
    return new TimeoutCommand(user, second);
  }

  /**
   * This command will allow you to permanently ban
   * a user from the chat room.
   */
  public static Command ban(String user) {
    return new BanCommand(user);
  }

  /**
   * This command allows you or your mods to restrict chat
   * to all or some of your followers, based on how long
   * they’ve followed — from 0 minutes (all followers) to 3 months.
   */
  public static Command followers(TimeUnit timeUnit) {
    return new FollowersCommand(timeUnit);
  }

  /**
   * This command will disable followers only mode
   * if it was previously enabled on the channel.
   */
  public static Command followersOff() {
    return new FollowersOffCommand();
  }

  /**
   * This command will allow the Broadcaster
   * and chat moderators to completely wipe
   * the previous chat history.
   */
  public static Command clear() {
    return new ClearCommand();
  }

  /**
   * This command disallows users from posting non-unique
   * messages to the channel.
   * It will check for a minimum of 9 characters that are
   * not symbol unicode characters and then purges any repetitive
   * chat lines beyond that.
   *
   * Uniquechat is a unique way of moderating, which essentially
   * allowing you to stop generic copy-pasted messages intended as
   * spam among over generally annoying content.
   */
  public static Command uniqueChat() {
    return new UniqueChatCommand();
  }

  /**
   * This command will disable Uniquechat mode if
   * it was previously enabled on the channel.
   */
  public static Command uniqueChatOff() {
    return new UniqueChatOffCommand();
  }

  /**
   * This command allows you to set your room so
   * only messages that are 100% emotes are allowed.
   */
  public static Command emoteOnly() {
    return new EmoteOnlyCommand();
  }

  /**
   * This command allows you to disable emote only mode
   * if you previously enabled it.
   */
  public static Command emoteOnlyOff() {
    return new EmoteOnlyOffCommand();
  }

  /**
   * An Affiliate and Partner command that runs a commercial for all of your viewers.
   */
  public static Command commercial(When when) {
    return new CommercialCommand(when);
  }

  /**
   * This command will allow you to host another channel on yours (embedded video player).
   */
  public static Command host(String channel) {
    return new HostCommand(channel);
  }

  /**
   * Using this command will revert the embedding from hosting a channel and return it to its normal state.
   */
  public static Command unhost() {
    return new UnhostCommand();
  }

  /**
   * This command will send the viewer to another live channel.
   */
  public static Command raid(String channel) {
    return new RaidCommand(channel);
  }

  /**
   * This command will cancel the raid.
   */
  public static Command unraid() {
    return new UnraidCommand();
  }

  /**
   * Adds a stream marker (with an optional description, max 140 characters)
   * at the current timestamp.
   * You can use markers in the Highlighter for easier editing.
   */
  public static Command marker(String description) {
    return new MarkerCommand(description);
  }

  /**
   * This command will allow you to promote a user to a channel moderator
   * allowing them to have access to all of the above commands and features.
   */
  public static Command addModerator(String user) {
    return new AddModeratorCommand(user);
  }

  /**
   * This command will allow you to demote an existing moderator back to viewer
   * status (removing their moderator abilities).
   */
  public static Command removeModerator(String user) {
    return new RemoveModeratorCommand(user);
  }

  /**
   * This command will grant VIP status to a user.
   */
  public static Command addVip(String user) {
    return new AddVipCommand(user);
  }

  /**
   * This command willl revoke VIP status from a user.
   */
  public static Command removeVip(String user) {
    return new RemoveVipCommand(user);
  }
}
