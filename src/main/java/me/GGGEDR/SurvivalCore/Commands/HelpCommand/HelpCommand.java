package me.GGGEDR.SurvivalCore.Commands.HelpCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§8» » » »  §a§lGlobal - Help  §8« « « «");
        sender.sendMessage("§a§lSlimeFun:");
        sender.sendMessage("§a/sf help§8- §7Help with SlimeFun");
        sender.sendMessage("§a§lSurvivalCore:");
        sender.sendMessage("§a/ad <text> §8- §7Publish your advertisement");
        sender.sendMessage("§a/tpa <player> §8- §7Send teleport request");
        sender.sendMessage("§a/spawn <player> §8- §7Teleport to spawn");
        sender.sendMessage("§a§lResidence:");
        sender.sendMessage("§a/res create <name> §8- §7Create residence");
        sender.sendMessage("§a/res remove <name> §8- §7Delete residence");
        sender.sendMessage("§a/res padd <player> §8- §7Add player to residence");
        sender.sendMessage("§a/res pdel <player> §8- §7Remove player from residence");
        sender.sendMessage("§a/res help §8- §7Use for more help with commands");
        sender.sendMessage("§8» » » »  §a§lGlobal - Help  §8« « « «");
        return false;
    }
}