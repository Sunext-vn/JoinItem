package vn.sunext.joinitem.containers;

import org.bukkit.entity.Player;

public interface ItemContainer {

    void addItem(Player player);

    void removeItem(Player player);

    void runCommand(Player player);

}
