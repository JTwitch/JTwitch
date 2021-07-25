package com.twitch.socket;

/**
 * represent the two type of socket connection :
 * <ul>
 *   <li>ws://url:80</li>
 *   <li>wss://url:443</li>
 * </ul>
 */
enum SecurityType {
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
