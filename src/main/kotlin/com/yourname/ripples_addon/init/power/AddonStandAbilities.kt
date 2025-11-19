package com.yourname.ripples_addon.init.power

import com.github.standobyte.jojo.core.JojoRegistries
import com.github.standobyte.jojo.powersystem.ability.Ability
import com.github.standobyte.jojo.powersystem.ability.AbilityId
import com.github.standobyte.jojo.powersystem.ability.AbilityType
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.registries.DeferredHolder
import java.util.function.Function

object AddonStandAbilities {
    fun load() {}

    val _PLACEHOLDER: DeferredHolder<AbilityType<*>?, AbilityType<Ability?>?> =
        JojoRegistries.ABILITY_TYPES.register<AbilityType<Ability?>?>(
            "test_placeholder",
            Function { key: ResourceLocation? ->
                AbilityType<Ability?>(
                    key
                ) { abilityType: AbilityType<Ability?>?, abilityId: AbilityId? ->
                    Ability(
                        abilityType,
                        abilityId
                    )
                }
            })
}