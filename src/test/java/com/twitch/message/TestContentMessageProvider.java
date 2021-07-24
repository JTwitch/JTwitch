package com.twitch.message;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestContentMessageProvider {

  @Test
  public void when_streamer_is_etoiles_then_return_etoiles() {
    // Given
    String in = ":nightbot!nightbot@nightbot.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "some message";
    // When
    String result = new MessageContentProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }

  @Test
  public void when_user_is_zerator_then_return_zerator() {
    // Given
    String in = ":nightbot!nightbot@nightbot.tmi.twitch.tv PRIVMSG #zerator :message: message";
    String out = "message: message";
    // When
    String result = new MessageContentProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }
}