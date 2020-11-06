package me.GGGEDR.SurvivalCore.Listeners;

import me.GGGEDR.SurvivalCore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {

    public static void startTiming(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendActionBar("§ax: §f"+ (int) p.getLocation().getBlockX() +" §ay: §f"+ (int) p.getLocation().getY() +" §az: §f"+ (int) p.getLocation().getZ());
                }
            }
        }, 0, 5);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        p.sendActionBar("§ax: §f"+ (int) p.getLocation().getBlockX() +" §ay: §f"+ (int) p.getLocation().getY() +" §az: §f"+ (int) p.getLocation().getZ());
    }

}
