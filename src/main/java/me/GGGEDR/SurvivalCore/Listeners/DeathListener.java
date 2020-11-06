package me.GGGEDR.SurvivalCore.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity().hasPermission("group.vip") || e.getEntity().hasPermission("group.friend")){
            e.getDrops().clear();
            e.setKeepInventory(true);
        } else {
            e.setKeepInventory(false);
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" was slain by")){
            String entity = e.getDeathMessage().split(e.getEntity().getName() +" was slain by ")[1];
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() + " §7bol zabitý §a"+ entity);
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" was fireballed by")){
            String entity = e.getDeathMessage().split(e.getEntity().getName() +" was fireballed by ")[1];
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() + " §7bol podpálený §a"+ entity);
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" fell from a high place")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7spadol s §7s velkej výški");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" fell from a high place")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7sa §azje** §7s velkej výški");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" hit the ground too hard")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7sa rozpleskol o §azem");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" tried to swim in lava")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7skúšal plávat v §cláve");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" was shot by Skeleton")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7bol rozdierkovanný §askeletonom");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" drowned")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7sa dokázal §butopit");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" drowned whilst trying to escape")){
            String entity = e.getDeathMessage().split(e.getEntity().getName() +" drowned whilst trying to escape ")[1];
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7sa zadusil pri tom ako utekal §a"+ entity);
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" blew up")){
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7sa nehal §arozstrelit");
        }

        if(e.getDeathMessage().contains(e.getEntity().getName() +" was blown up by")){
            String entity = e.getDeathMessage().split(e.getEntity().getName() +" was blown up by ")[1];
            e.setDeathMessage("§c| §a"+ e.getEntity().getName() +" §7bol §aodpálený §a"+ entity);
        }
        e.getEntity().sendMessage("§c| §7You died on the coordinates: §ax: §f"+ (int) e.getEntity().getLocation().getBlockX() +" §ay: §f"+ (int) e.getEntity().getLocation().getY() +" §az: §f"+ (int) e.getEntity().getLocation().getZ());
    }

    @EventHandler
    public void onMine(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.COAL_ORE) {
            Random rand = new Random();
            int n = rand.nextInt(100);
            n += 1;
            if(n < 30){
                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.TORCH));
            }
        }
    }

}