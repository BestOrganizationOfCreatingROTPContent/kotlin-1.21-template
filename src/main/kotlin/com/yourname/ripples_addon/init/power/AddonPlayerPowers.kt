package com.yourname.ripples_addon.init.power

import com.github.standobyte.jojo.core.JojoRegistries
import com.github.standobyte.jojo.powersystem.playerpower.PlayerPowerType
import com.yourname.ripples_addon.RipplesAddon
import net.neoforged.neoforge.registries.DeferredRegister

object AddonPlayerPowers {
    val PLAYER_POWERS: DeferredRegister<PlayerPowerType<*>?> = DeferredRegister.create(
        JojoRegistries.PLAYER_POWER_TYPES_REG,
        RipplesAddon.MOD_ID
    ) //	public static final Supplier<HmmmPowerType> HMMM = HmmmPowerType.HMMM;
}
