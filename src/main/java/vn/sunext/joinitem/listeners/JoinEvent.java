package vn.sunext.joinitem.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vn.sunext.joinitem.JoinItem;

public class JoinEvent implements Listener {

    private final JoinItem plugin = JoinItem.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        plugin.getItemSystem().onJoin(event);
    }

}
