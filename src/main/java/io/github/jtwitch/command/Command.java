package io.github.jtwitch.command;

/**
 * Broadcasters and channel moderators appointed by the broadcaster
 * are equipped with a set of commands and features that will allow
 * them to closely monitor and moderate the chat.
 * These features and commands range from giving a user a quick
 * timeout to built in anti-spam.
 *
 * @see ModeratorsCommand
 * @see VipsCommand
 * @see ColorCommand
 * @see BlockCommand
 * @see UnblockCommand
 * @see MeCommand
 * @see DisconnectCommand
 * @see WhisperCommand
 * @see MentionCommand
 *
 * @see DeleteCommand
 * @see TimeoutCommand
 * @see BanCommand
 * @see UnbanCommand
 * @see SlowCommand
 * @see SlowOffCommand
 * @see FollowersCommand
 * @see FollowersOffCommand
 * @see SubscribersOffCommand
 * @see SubscribersOffCommand
 * @see ClearCommand
 * @see UniqueChatCommand
 * @see UniqueChatOffCommand
 * @see EmoteOnlyCommand
 * @see EmoteOnlyOffCommand
 *
 * @see CommercialCommand
 * @see HostCommand
 * @see UnhostCommand
 * @see RaidCommand
 * @see UnraidCommand
 * @see MarkerCommand
 *
 * @see AddModeratorCommand
 * @see RemoveModeratorCommand
 * @see AddVipCommand
 * @see RemoveVipCommand
 */
public interface Command {

  String getCommand();
}
