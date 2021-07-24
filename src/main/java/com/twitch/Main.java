package com.twitch;

import com.twitch.socket.TwitchBot;

import java.net.URISyntaxException;

/**
 * Integration test
 */
public class Main {

  public static void main(String[] args) throws URISyntaxException, InterruptedException {
    var twitchBot = new TwitchBot("Nyphew_", "67po04dkncp0qdpry2w2iaiontuosl")
      .withActionOnMessage((bot, message) -> System.out.println(message))
      .withActionOnMessage((bot, message) -> {
        if (message.getMessageContent().contains("GG")) {
          bot.send(message.getStreamerName(), "Bravo !");
        }
      });
    twitchBot.connect();
    twitchBot.join("etoiles");
  }
}
