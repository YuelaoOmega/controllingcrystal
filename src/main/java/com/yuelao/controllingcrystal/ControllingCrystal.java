package com.yuelao.controllingcrystal;

import com.yuelao.controllingcrystal.event.PlayerJoinCallback;
import com.yuelao.controllingcrystal.item.ModItemGroup;
import com.yuelao.controllingcrystal.item.ModItems;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.event.player.UseItemCallback;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ControllingCrystal implements ModInitializer {
	public static final String MOD_ID = "controlling-crystal";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static List<String> PlayerNames = new ArrayList<>();
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution
		ModItems.intiialize();
		ModItemGroup.registerItemGroup();
		LOGGER.info("控制水晶！");

		//获取玩家名列表
		PlayerJoinCallback.EVENT.register((player, server) -> {
			boolean IsSamePlayer = false;
			String PlayerName = player.getDisplayName().getString();
			for (String i:PlayerNames){
				if (i.equals(PlayerName)){
					IsSamePlayer = true;
					break;
				}
			}
			if (!IsSamePlayer) {
				PlayerNames.add(player.getDisplayName().getString());
			}
		});


	}
}