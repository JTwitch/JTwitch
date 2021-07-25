package com.twitch.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static com.twitch.message.MessageType.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MessageTypeTest {

  @Parameter    public MessageType out;
  @Parameter(1) public String in;

  @Parameterized.Parameters(name = "\"{1}\" => {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {SUB,                     "sub"},
      {RESUB,                   "resub"},
      {SUB_GIFT,                "subgift"},
      {A_NON_SUB_GIFT,          "anonsubgift"},
      {SUB_MYSTERY_GIFT,        "submysterygift"},
      {GIFT_PAID_UPGRADE,       "giftpaidupgrade"},
      {REWARD_GIFT,             "rewardgift"},
      {A_NON_GIFT_PAID_UPGRADE, "anongiftpaidupgrade"},
      {HIGHLIGHT,               "highlighted-message"},
      {SKIP_SUBS_MODE_MESSAGE,  "skip-subs-mode-message"},
      {RAID,                    "raid"},
      {UNRAID,                  "unraid"},
      {RITUAL,                  "ritual"},
      {BITS_BADGE_TIER,         "bitsbadgetier"},
      {NORMAL,                  ""},
      {NORMAL,                  "toto"},
      {NORMAL,                  null},
    });
  }

  @Test
  public void test() {
    assertThat(MessageType.of(in)).isEqualTo(out);
  }
}