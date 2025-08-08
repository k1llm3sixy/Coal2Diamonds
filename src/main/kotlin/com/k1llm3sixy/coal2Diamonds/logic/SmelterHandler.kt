package com.k1llm3sixy.coal2Diamonds.logic

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPistonExtendEvent
import org.bukkit.plugin.java.JavaPlugin

class SmelterHandler(val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun coalSmelt(event: BlockPistonExtendEvent) {
        if (plugin.config.getBoolean("isSmelterEnabled")) {
            val blocks = event.blocks

            for (block in blocks) {
                val pistonDirection = event.direction == BlockFace.DOWN
                val loc = block.location
                val blockDown = loc.clone().add(0.0, -2.0, 0.0).block
                val blockDownType = blockDown.type
                val type = block.type == Material.MAGMA_BLOCK

                if (type && pistonDirection) {
                    when (blockDownType) {
                        Material.COAL_ORE -> blockDown.type = Material.DIAMOND_ORE
                        Material.DEEPSLATE_COAL_ORE -> blockDown.type = Material.DEEPSLATE_DIAMOND_ORE
                        else -> {}
                    }
                }
            }
        }
    }
}