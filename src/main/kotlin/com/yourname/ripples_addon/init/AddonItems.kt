package com.yourname.ripples_addon.init

import com.github.standobyte.jojo.init.ModItems
import com.yourname.ripples_addon.RipplesAddon
import net.minecraft.world.item.Item
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Function

@EventBusSubscriber(modid = RipplesAddon.MOD_ID)
object AddonItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(RipplesAddon.MOD_ID)

    val EXAMPLE_ITEM: DeferredItem<Item> = ITEMS.registerItem(
        "example_item",
        { properties -> Item(properties) },
        Item.Properties()
    )

    @SubscribeEvent
    fun addToTab(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey === ModItems.MAIN_TAB.key) {
            event.accept(EXAMPLE_ITEM)
        }
    }
}