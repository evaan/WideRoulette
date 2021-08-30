package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChannelMessage {
    public ChannelMessage(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(ChannelMessageEvent.class, event -> onMessage(event));
    }

    public void onMessage(ChannelMessageEvent event) {
        if (WideRoulette.wideEmote != null && event.getMessage().equalsIgnoreCase(WideRoulette.wideEmote)) {
            System.out.println(event.getUser().getName() + " HAS LOST THE WIDE ROULETTE 4TOWN");
            Bot.twitchClient.getChat().sendMessage("acoldone", "4Town " + event.getUser().getName());
            WideRoulette.wideEmote = null;
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception ignored) {}
            event.timeout(event.getUser().getName(), Duration.ofMinutes(10), "failed the wide roulette");
        }
    }
}
