package com.twitch.command;

import com.twitch.command.type.TimeUnit;

/**
 * This command allows you or your mods to restrict chat
 * to all or some of your followers, based on how long
 * they’ve followed — from 0 minutes (all followers) to 3 months.
 */
public record FollowersCommand(TimeUnit timeUnit) implements Command {

  @Override
  public String getCommand() {
    return "/followers " + timeUnit;
  }
}
