package com.k1llm3sixy.coal2Diamonds.cmds

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.Command
import org.bukkit.plugin.java.JavaPlugin

class CmdSmelter(val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage("Use: /coal2diamonds <enable|disable>")
            return false
        }

        when (args[0].lowercase()) {
            "enable" -> {
                sender.sendMessage("The plugin is enabled!")
                plugin.config.set("isSmelterEnabled", true)
                updateConfig()
            }
            "disable" -> {
                sender.sendMessage("The plugin is disabled!")
                plugin.config.set("isSmelterEnabled", false)
                updateConfig()
            }
            else -> {
                sender.sendMessage("Unknown subcommand. Use enable or disable!")
                return false
            }
        }
        return true
    }

    private fun updateConfig() {
        plugin.saveConfig()
        plugin.reloadConfig()
    }
}