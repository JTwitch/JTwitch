package com.twitch.message;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.twitch.message.MessageType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageTypeTest {

  @ParameterizedTest
  @ArgumentsSource(MessageTypeArgumentsProvider.class)
  public void test(MessageType out, String in) {
    assertThat(MessageType.of(in)).isEqualTo(out);
  }

  static class MessageTypeArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
        Arguments.of(SUB, "sub"),
        Arguments.of(RESUB, "resub"),
        Arguments.of(SUB_GIFT, "subgift"),
        Arguments.of(A_NON_SUB_GIFT, "anonsubgift"),
        Arguments.of(SUB_MYSTERY_GIFT, "submysterygift"),
        Arguments.of(GIFT_PAID_UPGRADE, "giftpaidupgrade"),
        Arguments.of(REWARD_GIFT, "rewardgift"),
        Arguments.of(A_NON_GIFT_PAID_UPGRADE, "anongiftpaidupgrade"),
        Arguments.of(HIGHLIGHT, "highlighted-message"),
        Arguments.of(SKIP_SUBS_MODE_MESSAGE, "skip-subs-mode-message"),
        Arguments.of(RAID, "raid"),
        Arguments.of(UNRAID, "unraid"),
        Arguments.of(RITUAL, "ritual"),
        Arguments.of(BITS_BADGE_TIER, "bitsbadgetier"),
        Arguments.of(NORMAL, ""),
        Arguments.of(NORMAL, "toto"),
        Arguments.of(NORMAL, null)
      );
    }
  }
}