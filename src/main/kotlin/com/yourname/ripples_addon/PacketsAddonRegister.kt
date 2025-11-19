package com.yourname.ripples_addon

import com.github.standobyte.jojo.core.PacketsRegister.PacketCodecHandler
import com.github.standobyte.jojo.core.PacketsRegister.PacketOGHandler
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.codec.StreamDecoder
import net.minecraft.network.codec.StreamMemberEncoder
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.handling.IPayloadContext
import net.neoforged.neoforge.network.handling.IPayloadHandler
import net.neoforged.neoforge.network.registration.PayloadRegistrar

/**
 * Register custom packets here.
 * You can see examples in [com.github.standobyte.jojo.core.PacketsRegister] from the base mod.
 */
object PacketsAddonRegister {
    fun register(event: RegisterPayloadHandlersEvent) {
        event.registrar("1")

        // Some examples from the base mod, uncomment and modify as needed:

        // Server packets:
        // registerPacket(registrar, PayloadRegistrar::playToServer, new ClAbilityInputPacket.Handler(JojoMod.resLoc("clkey")));

        // Client packets:
        // registerPacket(registrar, PayloadRegistrar::playToClient, new DatapackStandsPacket.Handler(JojoMod.resLoc("datastands")));
    }

    private fun <T : CustomPacketPayload> registerPacket(
        registrar: PayloadRegistrar,
        packetType: PacketType,
        handler: PacketOGHandler<T>
    ) {
        packetType.register(
            registrar,
            handler.type(),
            StreamCodec.ofMember(
                { packet: T, buf: RegistryFriendlyByteBuf -> handler.encode(packet, buf) },
                { buf: RegistryFriendlyByteBuf -> handler.decode(buf) }
            ),
            IPayloadHandler { payload: T, context: IPayloadContext -> handler.handle(payload, context) }
        )
    }

    private fun <T : CustomPacketPayload> registerPacket(
        registrar: PayloadRegistrar,
        packetType: PacketType,
        handler: PacketCodecHandler<T>
    ) {
        packetType.register(
            registrar,
            handler.type(),
            handler.reader(),
            IPayloadHandler { payload: T, context: IPayloadContext -> handler.handle(payload, context) }
        )
    }

    @FunctionalInterface
    private interface PacketType {
        fun <T : CustomPacketPayload?> register(
            registrar: PayloadRegistrar?,
            type: CustomPacketPayload.Type<T?>?,
            reader: StreamCodec<in RegistryFriendlyByteBuf?, T?>?,
            handler: IPayloadHandler<T?>?
        )
    }
}
