package com.yourname.ripples_addon.init.power

import com.github.standobyte.jojo.core.JojoRegistries
import com.github.standobyte.jojo.powersystem.MovesetBuilder
import com.github.standobyte.jojo.powersystem.ability.Ability
import com.github.standobyte.jojo.powersystem.ability.controls.InputKey
import com.github.standobyte.jojo.powersystem.ability.controls.InputMethod
import com.github.standobyte.jojo.powersystem.standpower.StandStats
import com.github.standobyte.jojo.powersystem.standpower.entity.EntityStandType
import com.github.standobyte.jojo.powersystem.standpower.type.StandType
import com.yourname.ripples_addon.RipplesAddon
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Function

object AddonStands {
    val STANDS: DeferredRegister<StandType?> =
        DeferredRegister.create<StandType?>(JojoRegistries.DEFAULT_STANDS_REG, RipplesAddon.MOD_ID)

    val EXAMPLE: DeferredHolder<StandType?, EntityStandType?> = STANDS.register(
        "example", Function { id: ResourceLocation? ->
            EntityStandType(
                StandStats.Builder()
                    .power(18.5)
                    .speed(19.0)
                    .range(2.0, 10.0)
                    .durability(20.0)
                    .precision(20.0)
                    .build(),

                MovesetBuilder()

                    .addHumanoidStandStuff()
                    .makeHotbar(0, InputKey.X, InputKey.C)

                    .addAbility<Ability?>("placeholder1", AddonStandAbilities._PLACEHOLDER)
                    .inHotbar(0, InputMethod.CLICK),

                id
            )
        })
}
