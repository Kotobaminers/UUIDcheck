package org.kotobaminers.uuidcheck.uuidcheck;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public final class UUIDcheckPlayerListener implements Listener {
	private final UUIDcheck plugin;

	public UUIDcheckPlayerListener(UUIDcheck plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void playerLogin(PlayerLoginEvent event) {
		if(event.getPlayer().getUniqueId().version() != 4) {
			plugin.printInfo("Warning /!\\ player with wrong UUID version has joined to the server!");

			plugin.printPlayerinfo(event.getPlayer());
			if(event.getPlayer().isOp()) {
				event.getPlayer().setOp(false);
				plugin.printInfo("    For safety reasons, OP is removed!");
				for(Player player : Bukkit.getServer().getOnlinePlayers()) {
					if(player.isOp()) {
						player.sendMessage("For safety reasons, player " + event.getPlayer().getName() + " OP is removed!");
					}
				}
			}
		}
	}
}
