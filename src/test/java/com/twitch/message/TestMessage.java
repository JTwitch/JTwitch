package com.twitch.message;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class TestMessage {

  @Test
  public void test_as_sub_message() {
    // Given
    String in = "@badge-info=;badges=broadcaster/1,premium/1;client-nonce=1b2ad004e5399c018d17657259439e4e;color=#16A085;msg-id=highlighted-message;display-name=Nyphew_;emotes=;flags=;id=24db27fb-6160-4c79-8f82-f687dcde4456;mod=0;room-id=57076120;subscriber=0;tmi-sent-ts=1627225532874;turbo=0;user-id=57076120;user-type= :nyphew_!nyphew_@nyphew_.tmi.twitch.tv PRIVMSG #nyphew_ :GG";
    String id = "24db27fb-6160-4c79-8f82-f687dcde4456";
    String streamerName = "nyphew_";
    String userName = "nyphew_";
    String messageContent = "GG";
    MessageType typeMessage = MessageType.HIGHLIGHT;
    // When
    var result = new Message(in);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getId()).isEqualTo(id);
      softly.assertThat(result.getStreamerName()).isEqualTo(streamerName);
      softly.assertThat(result.getUserName()).isEqualTo(userName);
      softly.assertThat(result.getMessageContent()).isEqualTo(messageContent);
      softly.assertThat(result.getMessageType()).isEqualTo(typeMessage);
    });
  }

  @Test
  public void test_as_resub_message() {
    // Given
    String in = "@badge-info=subscriber/2;badges=subscriber/0;client-nonce=84f7b701459c15e444c825298fb6afb6;color=;display-name=aelter;emotes=;flags=;msg-id=resub;id=7eeea85f-10ae-49de-8674-c8eb5b50eaa2;mod=0;reply-parent-display-name=Matthelot;reply-parent-msg-body=Imagine,\\st'es\\slà,\\stu\\sfais\\sune\\slose\\sstreak,\\scertes\\stu\\sjoues\\smal\\smais\\sça\\sarrive\\sd'avoir\\sde\\smauvaises\\spériodes,\\set\\slà\\st'as\\sun\\sstreamer\\squi\\st'insulte\\set\\sveut\\ste\\sfaire\\sperma\\sdu\\sjeu\\s:/;reply-parent-msg-id=bb651ba1-7fbd-474e-8184-9e46d799e85e;reply-parent-user-id=128337168;reply-parent-user-login=matthelot;room-id=50795214;subscriber=1;tmi-sent-ts=1627224406163;turbo=0;user-id=480357104;user-type= :aelter!aelter@aelter.tmi.twitch.tv PRIVMSG #sardoche :@Matthelot Tais-toi je t'en conjure\n";
    String id = "7eeea85f-10ae-49de-8674-c8eb5b50eaa2";
    String streamerName = "sardoche";
    String userName = "aelter";
    String messageContent = "@Matthelot Tais-toi je t'en conjure\n";
    MessageType typeMessage = MessageType.RESUB;
    // When
    var result = new Message(in);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getId()).isEqualTo(id);
      softly.assertThat(result.getStreamerName()).isEqualTo(streamerName);
      softly.assertThat(result.getUserName()).isEqualTo(userName);
      softly.assertThat(result.getMessageContent()).isEqualTo(messageContent);
      softly.assertThat(result.getMessageType()).isEqualTo(typeMessage);
    });
  }

  @Test
  public void test_with_no_specific_typeMessage() {
    // Given
    String in = "@badge-info=subscriber/2;badges=subscriber/0;client-nonce=84f7b701459c15e444c825298fb6afb6;color=;display-name=aelter;emotes=;flags=;id=7eeea85f-10ae-49de-8674-c8eb5b50eaa2;mod=0;reply-parent-display-name=Matthelot;reply-parent-msg-body=Imagine,\\st'es\\slà,\\stu\\sfais\\sune\\slose\\sstreak,\\scertes\\stu\\sjoues\\smal\\smais\\sça\\sarrive\\sd'avoir\\sde\\smauvaises\\spériodes,\\set\\slà\\st'as\\sun\\sstreamer\\squi\\st'insulte\\set\\sveut\\ste\\sfaire\\sperma\\sdu\\sjeu\\s:/;reply-parent-msg-id=bb651ba1-7fbd-474e-8184-9e46d799e85e;reply-parent-user-id=128337168;reply-parent-user-login=matthelot;room-id=50795214;subscriber=1;tmi-sent-ts=1627224406163;turbo=0;user-id=480357104;user-type= :aelter!aelter@aelter.tmi.twitch.tv PRIVMSG #sardoche :@Matthelot Tais-toi je t'en conjure\n";
    String id = "7eeea85f-10ae-49de-8674-c8eb5b50eaa2";
    String streamerName = "sardoche";
    String userName = "aelter";
    String messageContent = "@Matthelot Tais-toi je t'en conjure\n";
    MessageType typeMessage = MessageType.NORMAL;
    // When
    var result = new Message(in);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getId()).isEqualTo(id);
      softly.assertThat(result.getStreamerName()).isEqualTo(streamerName);
      softly.assertThat(result.getUserName()).isEqualTo(userName);
      softly.assertThat(result.getMessageContent()).isEqualTo(messageContent);
      softly.assertThat(result.getMessageType()).isEqualTo(typeMessage);
    });
  }

  @Test
  public void test_with_specific_user_name() {
    // Given
    String in = "@badge-info=;badges=broadcaster/1,premium/1;client-nonce=1b2ad004e5399c018d17657259439e4e;color=#16A085;msg-id=highlighted-message;display-name=Nyphew_;emotes=;flags=;id=24db27fb-6160-4c79-8f82-f687dcde4456;mod=0;room-id=57076120;subscriber=0;tmi-sent-ts=1627225532874;turbo=0;user-id=57076120;user-type= :estBot!!test!estBot!!test@estBot!!test.tmi.twitch.tv PRIVMSG #nyphew_ :GG";
    String id = "24db27fb-6160-4c79-8f82-f687dcde4456";
    String streamerName = "nyphew_";
    String userName = "estBot!!test";
    String messageContent = "GG";
    MessageType typeMessage = MessageType.HIGHLIGHT;
    // When
    var result = new Message(in);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getId()).isEqualTo(id);
      softly.assertThat(result.getStreamerName()).isEqualTo(streamerName);
      softly.assertThat(result.getUserName()).isEqualTo(userName);
      softly.assertThat(result.getMessageContent()).isEqualTo(messageContent);
      softly.assertThat(result.getMessageType()).isEqualTo(typeMessage);
    });
  }
}