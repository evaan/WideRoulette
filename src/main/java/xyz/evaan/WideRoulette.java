package xyz.evaan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WideRoulette {
    public static String wideEmote = null;
    public static ArrayList<String> emotes = new ArrayList<>();

    public static void wideTime(String redeemer) {
        if (wideEmote != null) {
            System.out.println("SOME DUMBSHIT DECIDED TO DO 2 WIDE ROULETTES AT THE SAME TIME");
            Bot.twitchClient.getChat().sendMessage("acoldone", "a wide roulette is already running get scammed 4Town");
            return;
        }
        System.out.println("A WIDE ROULETTE HAS BEEN REDEEMED BY " + redeemer);
        Collections.shuffle(emotes);
        wideEmote = emotes.get(0);
        Bot.twitchClient.getChat().sendMessage("acoldone", wideEmote + " is now the losing emote, good luck! WAYTOOWIDE");
        new TimeOutThread().start();
    }

    public static void wideTimeButFake(String redeemer) {
        System.out.println("A WIDE FAKE ROULETTE HAS BEEN REDEEMED BY " + redeemer);
        Bot.twitchClient.getChat().sendMessage("acoldone", wideEmote + " is now the losing emote, good luck! WAYTOOWIDE");
    }
}
