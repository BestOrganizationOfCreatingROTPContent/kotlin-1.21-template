package com.yourname.ripples_addon.init.power

import com.github.standobyte.jojo.core.JojoRegistries
import com.github.standobyte.jojo.powersystem.standpower.effect.StandEffectType
import com.yourname.ripples_addon.RipplesAddon
import net.neoforged.neoforge.registries.DeferredRegister

object AddonStandEffects {
    val STAND_EFFECT_TYPES: DeferredRegister<StandEffectType<*>?> =
        DeferredRegister.create(JojoRegistries.STAND_EFFECTS_REG, RipplesAddon.MOD_ID)
}