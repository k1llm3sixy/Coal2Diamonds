package com.k1llm3sixy.coal2Diamonds

import com.k1llm3sixy.coal2Diamonds.cmds.CmdSmelter
import com.k1llm3sixy.coal2Diamonds.logic.SmelterHandler
import org.bukkit.plugin.java.JavaPlugin

class Coal2Diamonds : JavaPlugin() {

    override fun onEnable() {
        logger.info("Starting plugin...")
        server.pluginManager.registerEvents(SmelterHandler(this), this)
        createConfig()
        getCommand("coal2diamonds")?.setExecutor(CmdSmelter(this))
    }

    private fun createConfig() {
        if (!dataFolder.exists()) dataFolder.mkdirs()
        saveDefaultConfig()
    }
}