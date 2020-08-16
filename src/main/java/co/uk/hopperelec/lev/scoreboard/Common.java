package co.uk.hopperelec.lev.scoreboard;

import java.io.File;

public class Common {
    Scoreboard main;
    public Common(Scoreboard mainClass) {main = mainClass;}

    public void reloadCustomConfig() {
        if(customConfigFile == null) {
            customConfigFile = new File(main.getDataFolder(), "customConfig.yml");
        }
        customConfig = yamlConfiguration.loadConfiguration;
    }
}
