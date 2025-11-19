package com.yourname.ripples_addon.init

import com.yourname.ripples_addon.RipplesAddon
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Function

object AddonSoundEvents {
    val SOUNDS: DeferredRegister<SoundEvent> =
        DeferredRegister.create(Registries.SOUND_EVENT, RipplesAddon.MOD_ID)

    val EXAMPLE_SOUND: DeferredHolder<SoundEvent, SoundEvent> = SOUNDS.register(
        "example"
    ) { location -> SoundEvent.createVariableRangeEvent(location) }
}
