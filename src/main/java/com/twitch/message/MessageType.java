package com.twitch.message;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Represent a type of message. <br />
 * for instance, {@link MessageType#SUB} represent a message writing by a user for his sub.
 */
public enum MessageType {
  SUB("sub"),
  RESUB("resub"),
  SUB_GIFT("subgift"),
  A_NON_SUB_GIFT("anonsubgift"),
  SUB_MYSTERY_GIFT("submysterygift"),
  GIFT_PAID_UPGRADE("giftpaidupgrade"),
  REWARD_GIFT("rewardgift"),
  A_NON_GIFT_PAID_UPGRADE("anongiftpaidupgrade"),

  HIGHLIGHT("highlighted-message"),
  SKIP_SUBS_MODE_MESSAGE("skip-subs-mode-message"),

  RAID("raid"),
  UNRAID("unraid"),

  RITUAL("ritual"),
  BITS_BADGE_TIER("bitsbadgetier"),

  NORMAL(null);

  private final String type;

  MessageType(String type) {
    this.type = type;
  }

  public static MessageType of(String type) {
    return Stream.of(values())
                 .filter(typeMessage -> Objects.equals(typeMessage.type, type))
                 .findFirst()
                 .orElse(NORMAL);
  }
}
