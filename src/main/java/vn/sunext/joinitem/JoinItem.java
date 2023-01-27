package vn.sunext.joinitem;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vn.sunext.joinitem.commands.MainCommand;
import vn.sunext.joinitem.functions.ColorSystem;
import vn.sunext.joinitem.functions.ConnectSystem;
import vn.sunext.joinitem.functions.ItemSystem;
import vn.sunext.joinitem.listeners.*;
import vn.sunext.joinitem.managers.FileManager;
import vn.sunext.joinitem.managers.PathManager;

import java.util.Objects;

@Getter
public final class JoinItem extends JavaPlugin {

    private static JoinItem plugin;

    private PathManager pathManager;
    private FileManager fileManager;

    private ColorSystem colorSystem;
    private ItemSystem itemSystem;
    private ConnectSystem connectSystem;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        pathManager = new PathManager();
        pathManager.register();

        fileManager = new FileManager();
        fileManager.register();

        colorSystem = new ColorSystem();
        itemSystem = new ItemSystem();
        connectSystem = new ConnectSystem();

        registerEvent(new ClickEvent());
        registerEvent(new DropEvent());
        registerEvent(new InteractEvent());
        registerEvent(new JoinEvent());
        registerEvent(new SwapEvent());

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        Objects.requireNonNull(getCommand("sendplayer")).setExecutor(new MainCommand());

        Bukkit.getOnlinePlayers().forEach(player -> itemSystem.onEnable(player));
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
