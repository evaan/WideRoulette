package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.common.enums.CommandPermission;
import com.github.twitch4j.common.events.user.PrivateMessageEvent;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ChannelMessage {
    public ChannelMessage(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(ChannelMessageEvent.class, event -> onMessage(event));
    }

    public void onMessage(ChannelMessageEvent event) {
        if (event.getMessage().equalsIgnoreCase("*forcestart") && event.getPermissions().contains(CommandPermission.MODERATOR)) WideRoulette.wideTime(event.getUser().getName());
        if (event.getMessage().equalsIgnoreCase("*fakestart") && event.getPermissions().contains(CommandPermission.MODERATOR)) {
            WideRoulette.wideTime(event.getUser().getName());
            WideRoulette.wideEmote = null;
        }
        if (WideRoulette.wideEmote != null && event.getMessage().equalsIgnoreCase(WideRoulette.wideEmote)) {
            System.out.println(event.getUser().getName() + " HAS LOST THE WIDE ROULETTE 4TOWN");
            Bot.twitchClient.getChat().sendMessage("acoldone", "4Town " + event.getUser().getName());
            WideRoulette.wideEmote = null;
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception ignored) {}
            if (!event.getPermissions().contains(CommandPermission.MODERATOR)) event.timeout(event.getUser().getName(), Duration.ofMinutes(10), "failed the wide roulette");
        }
    }
}
