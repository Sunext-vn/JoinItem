package vn.sunext.joinitem.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import vn.sunext.joinitem.JoinItem;

public class SwapEvent implements Listener {

    private final JoinItem plugin = JoinItem.getInstance();

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent event) {
        plugin.getItemSystem().onSwap(event);
    }

}
