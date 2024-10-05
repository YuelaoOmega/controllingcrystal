package com.yuelao.controllingcrystal;

import com.yuelao.controllingcrystal.event.PlayerJoinCallback;
import com.yuelao.controllingcrystal.item.ModItemGroup;
import com.yuelao.controllingcrystal.item.ModItems;

import com.yuelao.controllingcrystal.network.CoalControllingCrystalPayload;
import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.entity.player.PlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ControllingCrystal implements ModInitializer {
	public static final String MOD_ID = "controlling-crystal";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static List<UUID> Players = new ArrayList<>();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution
		ModItems.intiialize();
		ModItemGroup.registerItemGroup();
		LOGGER.info("控制水晶！");

		//监听玩家加入事件，
		PlayerJoinCallback.EVENT.register((player, server) -> {
			boolean IsSamePlayer = false;
			UUID PlayerUUidToCompare = player.getUuid();
			for (UUID i:Players){
				if (i.equals(PlayerUUidToCompare)){
					IsSamePlayer = true;
					break;
				}
			}
			if (!IsSamePlayer) {
				Players.add(PlayerUUidToCompare);
			}
		});

		//数据包接收_1级控制水晶
		PayloadTypeRegistry.playS2C().register(CoalControllingCrystalPayload.ID, CoalControllingCrystalPayload.CODEC);



	}
}