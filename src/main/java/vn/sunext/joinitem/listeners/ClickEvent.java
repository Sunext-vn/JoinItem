package vn.sunext.joinitem.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import vn.sunext.joinitem.JoinItem;

public class ClickEvent implements Listener {

    private final JoinItem plugin = JoinItem.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        plugin.getItemSystem().onClick(event);
    }

}
