package xyz.evaan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WideRoulette {
    public static String wideEmote = null;
    public static ArrayList<String> emotes = new ArrayList<>();

    public static void wideTime(String redeemer) {
        System.out.println("A WIDE ROULETTE HAS BEEN REDEEMED BY " + redeemer);
        Collections.shuffle(emotes);
        wideEmote = emotes.get(0);
        Bot.twitchClient.getChat().sendMessage("acoldone", wideEmote + " is now the losing emote, good luck!");
    }
}
