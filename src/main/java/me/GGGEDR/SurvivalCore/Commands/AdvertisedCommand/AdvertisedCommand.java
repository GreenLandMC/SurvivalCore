package me.GGGEDR.SurvivalCore.Commands.AdvertisedCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdvertisedCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            sender.sendMessage("§a§l* Use: \n§a/"+ command.getName() +" <text>");
        } else {
            if(!AdvertisedCache.isInCache(sender.getName())) {
                String content = null;
                for (int i = 0; i < args.length; i++) {
                    if (content == null) {
                        content = args[i];
                    } else {
                        content = content + " " + args[i];
                    }
                }
                Bukkit.broadcastMessage("§a§lAdvertised §2" + sender.getName() + " §8» §7" + content);
                Countdown countdown = new Countdown(sender.getName());
                countdown.startTiming();
                AdvertisedCache.addToCache(sender.getName(), countdown);
            } else {
                sender.sendMessage("§a§lAdvertised §8» §7Countdown for this command: §a"+ AdvertisedCache.getBoolean(sender.getName()).getTime());
            }
        }
        return false;
    }
}
