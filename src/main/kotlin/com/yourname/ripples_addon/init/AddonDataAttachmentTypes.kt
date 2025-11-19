package com.yourname.ripples_addon.init

import com.yourname.ripples_addon.RipplesAddon
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries

object AddonDataAttachmentTypes {
    val ATTACHMENT_TYPES: DeferredRegister<AttachmentType<*>?> = DeferredRegister.create(
        NeoForgeRegistries.ATTACHMENT_TYPES, RipplesAddon.MOD_ID
    ) //	public static final Supplier<AttachmentType<StandPower>> STAND_POWER = ATTACHMENT_TYPES.register("stand_power",
    //			() -> AttachmentType.serializable(entity -> PowerClass._tryAttach(entity, StandPower::new)).build());
}
