package xyz.evaan;

public class Launcher {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must add the account username and access token in the arguments.");
            return;
        }
        WideRoulette.emotes.add("WideConcern");
        WideRoulette.emotes.add("WideHard");
        WideRoulette.emotes.add("WideHardest1");
        WideRoulette.emotes.add("WideHardest2");
        WideRoulette.emotes.add("Widega");
        WideRoulette.emotes.add("WidenUp");
        WideRoulette.emotes.add("widePepeLaugh");
        WideRoulette.emotes.add("widepeepoBlanket");
        WideRoulette.emotes.add("widepeepoHappy");
        Bot wideRoulette = new Bot(args[0], args[1]);
        wideRoulette.registerEvents();
        System.out.println("WIDE ROULETTE BOT IS NOW READY");
    }
}
