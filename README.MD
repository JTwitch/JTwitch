# ![](./img/logo.png) JTwitch

Twitch api wrapper to create twitch bot with JVM langage.

## Use it with maven

```xml

<dependency>
    <groupId>com.jtwitch</groupId>
    <artifactId>jtwitch</artifactId>
    <version>1.0.0</version>
</dependency>
```

## exemple of code

An example of code to instantiate a bot saying `GG means Good Game` when someone says `GG` on Zerator's stream.

```java
public class Main {
  public static void main(String[] args) {
    new TwitchBot(user, token)
      .withActionOnMessage((bot, message) -> {
        if (message.getMessageContent().equals("GG")) {
          bot.send("GG means Good Game");
        }
      })
      .connect()
      .join("zerator");
  }
}
```

To authenticate your bot you need :

- A user account
- The token of this user (you can generate it [here](https://twitchapps.com/tmi/). 
it will gave you the token with format `oauth:token`. you just need the token part)

## Roadmap

- ✅ Send message
- ✅ Answer message
- ✅ Schedule message
- ✅ Delete message
- ⬜ Create easy command pattern
- ⬜ Remove a command
- ⬜ administrate channel with standard moderation command


## Report bugs

don't
