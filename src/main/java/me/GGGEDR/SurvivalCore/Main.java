package me.GGGEDR.SurvivalCore;

import me.GGGEDR.SurvivalCore.Commands.AdvertisedCommand.AdvertisedCommand;
import me.GGGEDR.SurvivalCore.Commands.HelpCommand.HelpCommand;
import me.GGGEDR.SurvivalCore.Commands.TpaCommand.TpaCmd;
import me.GGGEDR.SurvivalCore.Listeners.Chat.ChatListener;
import me.GGGEDR.SurvivalCore.Listeners.DeathListener;
import me.GGGEDR.SurvivalCore.Listeners.JoinLeaveMessages.MessagesJoinLeaveListener;
import me.GGGEDR.SurvivalCore.Listeners.Move;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static LuckPerms api;

    @Override
    public void onEnable() {
        instance = this;
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }
        // Plugin startup logic


        Bukkit.getPluginCommand("tpa").setExecutor(new TpaCmd());
        Bukkit.getPluginCommand("ad").setExecutor(new AdvertisedCommand());
        Bukkit.getPluginCommand("help").setExecutor(new HelpCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new MessagesJoinLeaveListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new Move(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance(){
        return instance;
    }
    public static LuckPerms getLuckPerms(){
        return api;
    }
}
