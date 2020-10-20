package me.GGGEDR.SurvivalCore.Commands.HelpCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§8» » » »  §c§lGlobal - Help  §8« « « «");
        sender.sendMessage("§c§lPumpkinFun:");
        sender.sendMessage("§c/pf menu §8- §7Open menu with categories");
        sender.sendMessage("§c§lSurvivalCore:");
        sender.sendMessage("§c/ad <text> §8- §7Publish your advertisement");
        sender.sendMessage("§c/tpa <player> §8- §7Send teleport request");
        sender.sendMessage("§c/spawn <player> §8- §7Teleport to spawn");
        sender.sendMessage("§c§lResidence:");
        sender.sendMessage("§c/res create <name> §8- §7Create residence");
        sender.sendMessage("§c/res remove <name> §8- §7Delete residence");
        sender.sendMessage("§c/res padd <player> §8- §7Add player to residence");
        sender.sendMessage("§c/res pdel <player> §8- §7Remove player from residence");
        sender.sendMessage("§c/res help §8- §7Use for more help with commands");
        sender.sendMessage("§8» » » »  §c§lGlobal - Help  §8« « « «");
        return false;
    }
}