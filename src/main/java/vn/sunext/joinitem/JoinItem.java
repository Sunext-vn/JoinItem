package vn.sunext.joinitem;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vn.sunext.joinitem.functions.ColorSystem;
import vn.sunext.joinitem.functions.ItemSystem;
import vn.sunext.joinitem.listeners.*;
import vn.sunext.joinitem.managers.PathManager;

@Getter
public final class JoinItem extends JavaPlugin {

    private static JoinItem plugin;

    private PathManager pathManager;

    private ColorSystem colorSystem;
    private ItemSystem itemSystem;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        pathManager = new PathManager();
        pathManager.register();

        colorSystem = new ColorSystem();
        itemSystem = new ItemSystem();

        registerEvent(new ClickEvent());
        registerEvent(new DropEvent());
        registerEvent(new InteractEvent());
        registerEvent(new JoinEvent());
        registerEvent(new SwapEvent());
    }

    @Override
    public void onDisable() {
        Bukkit.getOnlinePlayers().forEach(player -> itemSystem.onDisable(player));
    }

    private void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static JoinItem getInstance() {
        return plugin;
    }
}
