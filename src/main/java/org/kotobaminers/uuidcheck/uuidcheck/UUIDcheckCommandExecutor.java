package org.kotobaminers.uuidcheck.uuidcheck;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UUIDcheckCommandExecutor implements CommandExecutor {
	private final UUIDcheck plugin;

	public UUIDcheckCommandExecutor(UUIDcheck plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//		throw new NotImplementedException();
		if(command.getName().toLowerCase().equals("uuid")) {
			if(args.length == 1) {
				//TODO: update getPlayer()
				if(sender instanceof Player) {
					Player player = (Player) sender;
					if(player.isOp()) {
						tellplayeruuid(sender, args[0]);
					}
				} else {
					tellplayeruuid(sender, args[0]);
				}
			}
		}
		return false;
	}
	
	public void tellplayeruuid(CommandSender sender, String target) {
		Player t = Bukkit.getServer().getPlayer(target);
		if(sender instanceof Player) {
			sender.sendMessage("Player " + t.getName() + " UUID is:");
			sender.sendMessage(t.getUniqueId().toString());
			sender.sendMessage("UUID version is " + t.getUniqueId().version());
			
		}
		else
			sender.sendMessage("Player not found");

	}
}
