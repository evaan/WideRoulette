package xyz.evaan;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;

public class Bot {
    public static TwitchClient twitchClient;
    public static OAuth2Credential login;

    public Bot(String identityProvider, String accessToken) {
        login = new OAuth2Credential(identityProvider, accessToken);
        twitchClient = TwitchClientBuilder.builder()
                .withEnablePubSub(true)
                .withEnableChat(true)
                .withChatAccount(login)
                .build();
        twitchClient.getChat().joinChannel("acoldone"); //change this to the channel you want to use
        twitchClient.getPubSub().listenForChannelPointsRedemptionEvents(login, "75903749"); //the number is the channel id, i just found it on google, replace with the channel you want to use
    }

    public void registerEvents() {
        SimpleEventHandler eventHandler = twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class);
        ChannelMessage channelMessage = new ChannelMessage(eventHandler);
        RewardRedeem rewardRedeem = new RewardRedeem(eventHandler);
    }
}
