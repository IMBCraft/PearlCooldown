package net.cyberflame.pearlcooldown;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PearlCooldown extends JavaPlugin implements CommandExecutor {

    private String pearlName;
    private double cooldown;
    private int interval;
    private DecimalFormat format;
    private boolean asyncUpdate, xpBar, updateAvailable;

    @Override
    public void onEnable() {
        loadConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        long st = System.currentTimeMillis();
        reloadConfig();
        loadConfig();
        long et = System.currentTimeMillis();
        sender.sendMessage(
                ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "PearlCooldown was reloaded in " + (et - st) + " ms.");
        return true;
    }

    private void loadConfig() {
        saveDefaultConfig();
        format = new DecimalFormat(getConfig().getString("format"));
        pearlName = getConfig().getString("pearl-name");
        cooldown = getConfig().getDouble("cooldown");
        interval = getConfig().getInt("interval");
        xpBar = getConfig().getBoolean("xp-bar");
        asyncUpdate = getConfig().getBoolean("async-update");
    }

    public DecimalFormat getFormat() {
        return format;
    }

    public void setFormat(DecimalFormat format) {
        this.format = format;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public String getPearlName() {
        return pearlName;
    }

    public void setPearlName(String pearlName) {
        this.pearlName = pearlName;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int task) {
        this.interval = task;
    }

    public void setAsyncUpdate(boolean asyncUpdate) {
        this.asyncUpdate = asyncUpdate;
    }

    public boolean isAsyncUpdate() {
        return asyncUpdate;
    }

    public boolean isXpBar() {
        return xpBar;
    }

    public void setXpBar(boolean xpBar) {
        this.xpBar = xpBar;
    }

}