package vn.sunext.joinitem.functions;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import vn.sunext.joinitem.JoinItem;

public class ConnectSystem {

    private final JoinItem plugin = JoinItem.getInstance();

    public void sendPlayer(Player player, String serverName) {
        ByteArrayDataOutput dataOutput = ByteStreams.newDataOutput();
        dataOutput.writeUTF("Connect");
        dataOutput.writeUTF(serverName);
        player.sendPluginMessage(plugin, "BungeeCord", dataOutput.toByteArray());

        plugin.getFileManager().setLastJoinServer(player.getName(), serverName);
    }

}
