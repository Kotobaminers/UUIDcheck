package org.kotobaminers.uuidcheck.uuidcheck;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UUIDcheckCommandExecutor implements CommandExecutor {
	private final UUIDcheck plugin;

	public UUIDcheckCommandExecutor(UUIDcheck plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
		// return false;
	}
}
