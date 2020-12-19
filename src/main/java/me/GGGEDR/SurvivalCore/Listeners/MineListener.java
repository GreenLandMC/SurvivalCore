package me.GGGEDR.SurvivalCore.Listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class MineListener implements Listener {

    @EventHandler
    public void onMine(BlockBreakEvent e){
        Player miner = e.getPlayer();
        Location location = e.getBlock().getLocation();

        if(e.getBlock().getType() == Material.COAL_ORE) {
            bonusDrop(location, miner, Material.COAL, 30);
        }

        if(e.getBlock().getType() == Material.DIAMOND_ORE){
            sendAdminMineMessage(miner, "§b§lDiamond");
        }

        if(e.getBlock().getType() == Material.EMERALD_ORE){
            sendAdminMineMessage(miner, "§2§lEmerald");
        }

        if(e.getBlock().getType() == Material.GOLD_ORE){
            sendAdminMineMessage(miner, "§6§lZlato");
            bonusDrop(location, miner, Material.GOLD_INGOT, 25);
        }

        if(e.getBlock().getType() == Material.IRON_ORE){
            sendAdminMineMessage(miner, "§f§lŽelezo");
            bonusDrop(location, miner, Material.IRON_INGOT, 25);
        }
    }

    public void sendAdminMineMessage(Player miner, String block){
        for(Player p: Bukkit.getOnlinePlayers()){
            if(p.hasPermission("admin.*")){
                p.sendMessage("§a§lStaffMine §8» §7Hráč: §a"+ miner.getName() +" §7vykopal "+ block);
            }
        }
    }

    public int getPercentageNumber(){
        Random rand = new Random();
        int n = rand.nextInt(100);
        n += 1;
        return n;
    }

    public void bonusDrop(Location location,Player miner, Material material, int percentage){
        if(getPercentageNumber() < percentage){
            location.getWorld().dropItemNaturally(location, new ItemStack(material));
            miner.playNote(location, Instrument.PIANO, Note.flat(1, Note.Tone.C));
        }
    }
}
