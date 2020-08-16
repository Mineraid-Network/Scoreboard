package co.uk.hopperelec.lev.scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    Scoreboard main;
    public Events(Scoreboard mainClass) {
        main = mainClass;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        main.createBoard(event.getPlayer());
    }
}
