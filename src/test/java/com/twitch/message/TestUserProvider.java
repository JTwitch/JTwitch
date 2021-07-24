package com.twitch.message;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUserProvider {


  @Test
  public void when_user_is_nightbot_then_return_nightbot() {
    // Given
    String in = ":nightbot!nightbot@nightbot.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "nightbot";
    // When
    String result = new UserProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }

  @Test
  public void when_user_is_charles_then_return_charles() {
    // Given
    String in = ":charles!charles@charles.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "charles";
    // When
    String result = new UserProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }

  @Test
  public void when_user_has_exclamation_point_then_return_with_exclamation_point() {
    // Given
    String in = ":testBot!!testBot!@testBot!.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "testBot!";
    // When
    String result = new UserProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }

  @Test
  public void when_user_has_exclamation_point_and_text_after_then_return_with_exclamation_point_and_text_after() {
    // Given
    String in = ":testBot!!test!testBot!!test@testBot!!test.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "testBot!!test";
    // When
    String result = new UserProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }

  @Test
  public void when_user_has_at_symbol_then_return_with_at_symbol() {
    // Given
    String in = ":testBot@!testBot@@testBot@.tmi.twitch.tv PRIVMSG #etoiles :some message";
    String out = "testBot@";
    // When
    String result = new UserProvider().apply(in);
    // Then
    assertThat(result).isEqualTo(out);
  }
}