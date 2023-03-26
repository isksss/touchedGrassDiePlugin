package dev.isksss.mc.touchedgrassdieplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TouchedGrassDiePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onTouchGrass(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location playerLoc = player.getLocation();


        //一個下のブロック
        int blockLocX =playerLoc.getBlockX();
        int blockLocY =playerLoc.getBlockY() - 1;
        int blockLocZ =playerLoc.getBlockZ();

        Location blockLoc = null;
        blockLoc.set(blockLocX,blockLocY,blockLocZ);

        Block block = blockLoc.getBlock();
        Material material = block.getBlockData().getMaterial();

        //todo: 草ブロックにふれたプレイヤーをキル
        if (material == Material.GRASS_BLOCK || material == Material.GRASS){
            player.setKiller(player);
            e.setCancelled(true);
        }
    }
}
