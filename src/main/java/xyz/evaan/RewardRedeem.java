package xyz.evaan;

import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;

public class RewardRedeem {
    public RewardRedeem(SimpleEventHandler eventHandler) {
        eventHandler.onEvent(RewardRedeemedEvent.class, event -> onRedeem(event));
    }

    public void onRedeem(RewardRedeemedEvent event) {
        if (event.toString().toLowerCase().contains("title=wide roulette,")) WideRoulette.wideTime(event.getRedemption().getUser().getDisplayName());
    }
}
