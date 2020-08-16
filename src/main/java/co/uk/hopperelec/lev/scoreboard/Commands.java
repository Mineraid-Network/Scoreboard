package co.uk.hopperelec.lev.scoreboard;

import org.bukkit.entity.Player;

public class Commands {
    Scoreboard main;
    public Commands(Scoreboard mainClass) {
        main = mainClass;
    }

    public boolean handle(Player author, String[] args) {
        if (args[0].equalsIgnoreCase("reload") && author.hasPermission("scoreboard.reload")) {
            main.reloadConfig();
            main.common.reloadCustomConfig();
        } else {
            author.sendMessage(main.pre+"Unknown subcommand '"+args[0]+"'!");
            return false;
        }

        return true;
    }
}
