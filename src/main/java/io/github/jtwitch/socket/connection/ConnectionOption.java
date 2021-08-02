package io.github.jtwitch.socket.connection;

/**
 * Describe options to create a socket connection through the twitch IRC socket.
 */
public class ConnectionOption {

  private static final String URL = "%s://irc-ws.chat.twitch.tv:%d/irc";

  private final TwitchCredential credential;

  private SecurityType securityType = SecurityType.STANDARD_PROTOCOL;

  /**
   * The only constructor.
   * @param botAccount the name of the bot account. for instance,
   *                   if your bot account is {@code nightbot}, the botAccount is {@code nightbot}
   * @param token the connection token the you generate <a href="https://twitchapps.com/tmi/">here</a>
   */
  public ConnectionOption(String botAccount, String token) {
    this.credential = new TwitchCredential(botAccount, token);
  }

  /**
   * trigger the socket to connect to the SSL connection of twitch
   */
  public void secureConnection() {
    securityType = SecurityType.SECURE_PROTOCOL;
  }

  /**
   * @return the formatted url connection
   */
  public String getConnectionUrl() {
    return String.format(URL, securityType.getExtention(), securityType.getPort());
  }

  /**
   * @return userName credential
   */
  public String getUser() {
    return credential.user();
  }

  /**
   * @return the token to connection to the twitch IRC socket.
   */
  public String getToken() {
    return credential.token();
  }

  /** The credential ton connect to the twitch IRC socket */
  private record TwitchCredential(String user, String token) {}

  private enum SecurityType {
    STANDARD_PROTOCOL("ws", 80),
    SECURE_PROTOCOL("wss", 443);

    private final String extention;
    private final int port;

    SecurityType(String extention, int port) {
      this.extention = extention;
      this.port = port;
    }

    String getExtention() {
      return extention;
    }

    int getPort() {
      return port;
    }
  }
}
