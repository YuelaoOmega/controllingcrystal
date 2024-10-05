package com.yuelao.controllingcrystal.network;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Uuids;
import net.minecraft.util.dynamic.Codecs;

import java.util.UUID;


public record CoalControllingCrystalPayload(UUID playerUUID) implements CustomPayload {
    public static final CustomPayload.Id<CoalControllingCrystalPayload> ID = new CustomPayload.Id<>(ControllingCrystalConstants.Packet_Id_Coal);
    public static final PacketCodec<RegistryByteBuf, CoalControllingCrystalPayload> CODEC = PacketCodec.tuple(Uuids.PACKET_CODEC,CoalControllingCrystalPayload::playerUUID, CoalControllingCrystalPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId(){
        return ID;
    }
}
