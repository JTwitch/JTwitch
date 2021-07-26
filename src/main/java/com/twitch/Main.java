package com.twitch;

import com.twitch.socket.TwitchBot;

import java.net.URISyntaxException;

public class Main {

  public static void main(String[] args) throws URISyntaxException, InterruptedException {
    new TwitchBot("nyphew_", "kifj8ygou6uc29kfcrrg125i1991of")
      .withActionOnMessage((bot, message) -> {
        if (message.getMessageContent().equals("GG")) {
          bot.send(message.getStreamerName(), "GG means Good Game");
        }
      })
      .connect()
      .join("nyphew_");
  }
}
