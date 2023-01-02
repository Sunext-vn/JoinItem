package vn.sunext.joinitem.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import vn.sunext.joinitem.JoinItem;

public class InteractEvent implements Listener {

    private final JoinItem plugin = JoinItem.getInstance();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        plugin.getItemSystem().onInteract(event);
    }

}
