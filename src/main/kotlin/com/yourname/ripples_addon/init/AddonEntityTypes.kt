package com.yourname.ripples_addon.init

import com.yourname.ripples_addon.RipplesAddon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
import net.neoforged.neoforge.registries.DeferredRegister

@EventBusSubscriber(modid = RipplesAddon.MOD_ID)
object AddonEntityTypes {
    val ENTITY_TYPES: DeferredRegister<EntityType<*>?> =
        DeferredRegister.create(Registries.ENTITY_TYPE, RipplesAddon.MOD_ID)

    @SubscribeEvent
    fun registerAttributes(event: EntityAttributeCreationEvent?) {
//		event.put(EXAMPLE.get(), ArmorStand.createAttributes().build());
    }

    //	public static final DeferredHolder<EntityType<?>, EntityType<MannequinEntity>> EXAMPLE = ENTITY_TYPES.register("example", key ->
    //			EntityType.Builder.<MannequinEntity>of(MannequinEntity::new, MobCategory.MISC)
    //			.sized(0.5F, 1.975F)
    //			.eyeHeight(1.7775F)
    //			.clientTrackingRange(10)
    //			.build(createIDFor(key)));
    fun createIDFor(key: ResourceLocation): String {
        return key.toString()
    }
}
