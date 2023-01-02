package vn.sunext.joinitem.functions;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vn.sunext.joinitem.JoinItem;
import vn.sunext.joinitem.constructors.ChooseServerItem;
import vn.sunext.joinitem.managers.PathManager;

import java.util.List;
import java.util.Objects;

public class ItemSystem {

    private final JoinItem plugin = JoinItem.getInstance();
    private final ColorSystem colorSystem = plugin.getColorSystem();

    ChooseServerItem chooseServerItem = valuesToItem(PathManager.ITEM_NAME, PathManager.ITEM_MATERIAL,
            PathManager.ITEM_GLOW, PathManager.ITEM_SLOT, PathManager.ITEM_COMMAND, PathManager.ITEM_LORE);

    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        chooseServerItem.addItem(player);
    }

    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {

            if (Objects.equals(event.getItem(), chooseServerItem.getItemStack())) {
                Player player = event.getPlayer();

                chooseServerItem.runCommand(player);
            }

        }
    }

    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        ItemStack itemStack = event.getItemDrop().getItemStack();

        if (Objects.equals(itemStack, chooseServerItem.getItemStack())) {
            player.sendMessage(colorSystem.color("&cServer &7> &aNhấn chuột phải để chọn server!"));

            event.setCancelled(true);
        }
    }

    public void onClick(InventoryClickEvent event) {
        int slot = event.getSlot();

        if (slot == chooseServerItem.getSlot())
            event.setCancelled(true);
    }

    public void onSwap(PlayerSwapHandItemsEvent event) {
        if (Objects.equals(event.getOffHandItem(), chooseServerItem.getItemStack()))
            event.setCancelled(true);
    }

    public void onEnable(Player player) {
        chooseServerItem.addItem(player);
    }

    public void onDisable(Player player) {
        chooseServerItem.removeItem(player);
    }

    private ChooseServerItem valuesToItem(String name, String material, Boolean glow,
                                              Integer slot, String command, List<String> lore) {

        String resultName = colorSystem.color(name);
        Material resultMaterial = Material.matchMaterial(material);
        List<String> resultLore = colorSystem.color(lore);

        ItemStack stack = valuesToItemStack(resultName, resultMaterial, glow, resultLore);

        return new ChooseServerItem(stack, slot, command);
    }

    private ItemStack valuesToItemStack(String name, Material material, Boolean glow, List<String> lore) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(lore);

        if (glow) {
            meta.addEnchant(Enchantment.DURABILITY, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        stack.setItemMeta(meta);

        return stack;
    }

}
