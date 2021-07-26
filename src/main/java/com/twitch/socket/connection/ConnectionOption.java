package com.twitch.socket.connection;

public class ConnectionOption {

  private static final String URL = "%s://irc-ws.chat.twitch.tv:%d/irc";

  private final TwitchCredential credential;
  private SecurityType securityType = SecurityType.STANDARD_PROTOCOL;

  public ConnectionOption(String botAccount, String token) {
    this.credential = new TwitchCredential(botAccount, token);
  }

  /**
   * trigger the socket to connect to the SSL connection of twitch
   */
  public void secureConnection() {
    securityType = SecurityType.SECURE_PROTOCOL;
  }

  public String getConnectionUrl() {
    return String.format(URL, securityType.getExtention(), securityType.getPort());
  }

  public String getUser() {
    return credential.user();
  }

  public String getToken() {
    return credential.token();
  }
}
