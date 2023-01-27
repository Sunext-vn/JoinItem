package vn.sunext.joinitem.managers;

import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.joinitem.JoinItem;

import java.io.File;

public class FileManager {

    private final JoinItem plugin = JoinItem.getInstance();

    public void register() {
        loadDatabase();
    }

    @SneakyThrows
    private void loadDatabase() {
        File databaseFile = new File(plugin.getDataFolder(), "database.yml");

        if (!databaseFile.exists())
            databaseFile.createNewFile();
    }

    @SneakyThrows
    public void setLastJoinServer(String playerName, String serverName) {
        File databaseFile = new File(plugin.getDataFolder(), "database.yml");
        YamlConfiguration database = YamlConfiguration.loadConfiguration(databaseFile);

        database.set(playerName, serverName);

        database.save(databaseFile);
    }

    public String getLastJoinServer(String playerName) {
        File databaseFile = new File(plugin.getDataFolder(), "database.yml");
        YamlConfiguration database = YamlConfiguration.loadConfiguration(databaseFile);

        if (database.getString(playerName) == null)
            return "";

        return database.getString(playerName);
    }

}
