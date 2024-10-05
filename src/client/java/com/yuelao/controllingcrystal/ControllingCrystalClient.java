package com.yuelao.controllingcrystal;

import com.yuelao.controllingcrystal.network.CoalControllingCrystalPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;


import java.util.UUID;

import static com.yuelao.controllingcrystal.ControllingCrystal.LOGGER;

public class ControllingCrystalClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		// 数据包处理-1级控制水晶
		ClientPlayNetworking.registerGlobalReceiver(CoalControllingCrystalPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				UUID player = payload.playerUUID();
				LOGGER.info(player.toString());

			});
		});
	}
}