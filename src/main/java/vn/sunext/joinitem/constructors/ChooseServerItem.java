package vn.sunext.joinitem.constructors;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import vn.sunext.joinitem.containers.ItemContainer;

@Getter
@Setter
public class ChooseServerItem implements ItemContainer {

    ItemStack itemStack;
    Integer slot;
    String command;

    public ChooseServerItem(ItemStack itemStack, Integer slot, String command) {
        this.itemStack = itemStack;
        this.slot = slot;
        this.command = command;
    }

    @Override
    public void addItem(Player player) {
        Inventory inventory = player.getInventory();

        inventory.setItem(slot, itemStack);
    }

    @Override
    public void removeItem(Player player) {
        Inventory inventory = player.getInventory();

        inventory.setItem(slot, new ItemStack(Material.AIR));
    }

    @Override
    public void runCommand(Player player) {
        player.chat("/" + command);
    }
}
