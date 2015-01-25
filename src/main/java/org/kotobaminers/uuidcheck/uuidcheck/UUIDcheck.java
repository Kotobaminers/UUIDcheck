package org.kotobaminers.uuidcheck.uuidcheck;

import java.net.InetSocketAddress;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UUIDcheck extends JavaPlugin {
	static boolean debug = false;
	static Logger log = Bukkit.getLogger();

	@Override
	public void onEnable() {
		this.getCommand("uuid").setExecutor(new UUIDcheckCommandExecutor(this));
		Bukkit.getServer().getPluginManager().registerEvents(new UUIDcheckPlayerListener(this), this);
	}

	@Override
	public void onDisable() {
		printInfo("Disabling UUIDcheck");
	}

	public void printPlayerinfo(Player player) {
		String ip = "unknow";
		try {
			ip = player.getAddress().getAddress().getHostAddress().toString();
		} catch(Exception e) {
			UUIDcheck.printDebug("Could not get IP", e);
		}
		UUIDcheck.printInfo("Player " + player.getUniqueId().toString() + " has joined");
		UUIDcheck.printInfo("    DisplayName:   " + player.getDisplayName());
		UUIDcheck.printInfo("    CustomName:    " + player.getCustomName());
		UUIDcheck.printInfo("    Address:       " + ip);
		UUIDcheck.printInfo("    UUID version:  " + player.getUniqueId().version());
		if(player.isOp()) {
			UUIDcheck.printInfo("    Player is OP:  " + "true");
		}
		else {
			UUIDcheck.printInfo("    Player is OP:  " + "false");
		}
	}

	/**
	 * Print info message to server console
	 * 
	 * @param message
	 *            message
	 */
	public static void printInfo(String message) {
		log.info("[UUIDcheck] " + message);
	}

	/**
	 * Print info message to server console and sender if any
	 * 
	 * @param sender
	 *            command sender
	 * @param message
	 *            message to send
	 */
	public static void printInfo(CommandSender sender, String message) {
		log.info("[UUIDcheck] " + message);
		if(sender instanceof Player)
			sender.sendMessage(message);

	}

	/**
	 * Print Debug message to server console
	 * 
	 * @param message
	 *            debug message
	 */
	public static void printDebug(String message) {
		if(debug) {
			log.info("[UUIDcheck Debug] " + message);
		}
	}

	/**
	 * Print Debug message and StackTrace to server console and Example usage:
	 * KotobaAnnounce.printDebug("", new Exception());
	 * 
	 * @param message
	 *            debug message
	 * @param e
	 *            Exception
	 */
	public static void printDebug(String message, Exception e) {
		if(debug) {
			StackTraceElement element = e.getStackTrace()[0];
			String[] splited = element.getClassName().split("\\.");
			String nameClass = splited[splited.length - 1];
			String nameMethod = element.getMethodName();
			String line = String.valueOf(element.getLineNumber());
			log.info("[UUIDcheck Debug] " + message + " " + nameClass + " " + nameMethod + " " + line);
		}
	}
}
