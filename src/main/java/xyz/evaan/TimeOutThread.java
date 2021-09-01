package xyz.evaan;

import java.util.concurrent.TimeUnit;

public class TimeOutThread extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception ignored) {}
        if (WideRoulette.wideEmote == null) return;
        Bot.twitchClient.getChat().sendMessage("acoldone", "no losers ResidentSleeper");
        System.out.println("NO WINNER DEAD CHAT");
        WideRoulette.wideEmote = null;
    }
}
