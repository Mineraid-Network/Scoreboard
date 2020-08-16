package co.uk.hopperelec.lev.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class Scoreboard extends JavaPlugin {
    Commands commands = new Commands(this);
    Common common = new Common(this);
    ScoreboardManager scoreboardManager;
    FileConfiguration config;
    String pre;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        pre = config.getString("messagePrefix");

        this.getServer().getPluginManager().registerEvents(new Events(this), this);

        scoreboardManager = Bukkit.getScoreboardManager();
        if (scoreboardManager == null) {
            System.out.println("Failed to get a valid scoreboard manager!");
            setEnabled(false); return;
        }

        // Allows /reload without removing player scoreboards
        if (Bukkit.getOnlinePlayers().isEmpty())
            for (Player online : Bukkit.getOnlinePlayers())
                createBoard(online);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender author, Command cmd, String label, String[] args) {
        if (author instanceof Player) return commands.handle((Player) author, args);
        else System.out.println("Commands of this plugin currently aren't available through console!");
        return false;
    }


    public void createBoard(Player player) {
        org.bukkit.scoreboard.Scoreboard board = scoreboardManager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Lobby", "dummy");
        obj.setDisplayName("Tester"); // Sets top row of scoreboard
        obj.setDisplaySlot(DisplaySlot.SIDEBAR); //Sets position

        //Sets text lines
        Score score = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=-=-=-=; ");
        score.setScore(3);
        Score score2 = obj.getScore(ChatColor.AQUA + "Online Players: " + ChatColor.DARK_AQUA + Bukkit.getOnlinePlayers().size());
        score2.setScore(2);
        Score score3 = obj.getScore(ChatColor.AQUA + "Rank: " + ChatColor.DARK_AQUA + "Place holder");
        score3.setScore(1);
        player.setScoreboard(board);
    }
}

