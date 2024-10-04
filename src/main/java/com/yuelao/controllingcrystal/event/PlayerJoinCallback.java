package com.yuelao.controllingcrystal.event;


import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;


public interface PlayerJoinCallback {
    Event<PlayerJoinCallback> EVENT = EventFactory.createArrayBacked(PlayerJoinCallback.class,
            (listeners)
            -> (player,server)
            -> {
        for (PlayerJoinCallback listener : listeners){
            listener.joinServer(player,server);
        }

    });

    void joinServer(PlayerEntity player, MinecraftServer server);
}
