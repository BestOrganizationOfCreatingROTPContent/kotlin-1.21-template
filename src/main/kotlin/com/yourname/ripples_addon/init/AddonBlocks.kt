package com.yourname.ripples_addon.init

import com.yourname.ripples_addon.RipplesAddon
import net.neoforged.neoforge.registries.DeferredRegister

object AddonBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(RipplesAddon.MOD_ID)
}
