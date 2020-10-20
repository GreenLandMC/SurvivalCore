package me.GGGEDR.SurvivalCore.Commands.TpaCommand;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class TpaCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            sender.sendMessage("§c§l* Use: \n§c/"+ command.getName() +" <player>");
        } else if(args.length == 1){
            if(Bukkit.getPlayer(args[0]) != null){
                Teleporter teleporter = new Teleporter((Player) sender, Bukkit.getPlayer(args[0]));
                teleporter.startTiming();
                TpaCache.addToCache(sender.getName(), teleporter);
                TextComponent non_1 = new TextComponent("            ");
                TextComponent non_2 = new TextComponent("     ");
                TextComponent yes = new TextComponent(TextComponent.fromLegacyText("§a§l[Yes]"));
                yes.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/"+ command.getName() +" accept "+ sender.getName()));
                yes.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§aClick to accept\nTeleport to you request")));
                TextComponent no = new TextComponent(TextComponent.fromLegacyText("§c§l[No]"));
                no.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/"+ command.getName() +" cancel "+ sender.getName()));
                no.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§cClick to cancel\nTeleport to you request")));
                sender.sendMessage("§c§lTpa §8» §7Request to teleport for: §c"+ args[0] +" §7has been send! (30 sec. to accept)");
                Bukkit.getPlayer(args[0]).sendMessage("§c§lTpa §8» §7Request from player: §c"+ sender.getName() +" §7to teleport to you!");
                Bukkit.getPlayer(args[0]).spigot().sendMessage(non_1, yes, non_2, no);
            } else {
                sender.sendMessage("§c§lTpa §8» §7This player is offline!");
            }
        } else if(args.length == 2){
            if(args[0].equalsIgnoreCase("accept")){
                if(Bukkit.getPlayer(args[1]) != null){
                    if(TpaCache.isInCache(args[1]) && TpaCache.getTeleporterClass(args[1]).getTeleport_to().getName().equalsIgnoreCase(sender.getName())){
                        sender.sendMessage("§c§lTpa §8» §7You accepted teleport request from: §c"+ args[1]);
                        Bukkit.getPlayer(args[1]).sendMessage("§c§lTpa §8» §7Player: §c"+ sender.getName() +" §7accepted your teleport request!");
                        TpaCache.getTeleporterClass(args[1]).accept();
                    } else {
                        sender.sendMessage("§c§lTpa §8» §7This request for teleport has been expired!");
                    }
                } else {
                    sender.sendMessage("§c§lTpa §8» §7This player is offline!");
                }
            } else if(args[0].equalsIgnoreCase("cancel")){
                if(Bukkit.getPlayer(args[1]) != null){
                    if(TpaCache.isInCache(args[1]) && TpaCache.getTeleporterClass(args[1]).getTeleport_to().getName().equalsIgnoreCase(sender.getName())){
                        sender.sendMessage("§c§lTpa §8» §7You canceled teleport request from: §c"+ args[1]);
                        Bukkit.getPlayer(args[1]).sendMessage("§c§lTpa §8» §7Player: §c"+ sender.getName() +" §7canceled your teleport request!");
                        TpaCache.getTeleporterClass(args[1]).cancel();
                    } else {
                        sender.sendMessage("§c§lTpa §8» §7This request for teleport has been expired!");
                    }
                } else {
                    sender.sendMessage("§c§lTpa §8» §7This player is offline!");
                }
            } else {
                sender.sendMessage("§c§l* Use: \n§c/"+ command.getName() +" <player>");
            }
        } else {
            sender.sendMessage("§c§l* Use: \n§c/"+ command.getName() +" <player>");
        }
        return false;
    }
}
