package vn.sunext.joinitem.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import vn.sunext.joinitem.JoinItem;

public class DropEvent implements Listener {

    private final JoinItem plugin = JoinItem.getInstance();

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        plugin.getItemSystem().onDrop(event);
    }

}
