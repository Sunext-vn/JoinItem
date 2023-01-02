package vn.sunext.joinitem.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import vn.sunext.joinitem.JoinItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathManager {

    private final JoinItem plugin = JoinItem.getInstance();

    public static String ITEM_NAME = "";
    public static String ITEM_MATERIAL = "";
    public static Boolean ITEM_GLOW = false;
    public static Integer ITEM_SLOT = 0;
    public static String ITEM_COMMAND = "";
    public static List<String> ITEM_LORE = new ArrayList<>();

    public void register() {
        File config_file = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(config_file);

        ITEM_LORE.clear();

        ITEM_NAME = config.getString("item.name");
        ITEM_MATERIAL = config.getString("item.material");
        ITEM_GLOW = config.getBoolean("item.glow");
        ITEM_SLOT = config.getInt("item.slot");
        ITEM_COMMAND = config.getString("item.command");
        ITEM_LORE = config.getStringList("item.lore");
    }

}
