package com.yuelao.controllingcrystal;

import com.mojang.blaze3d.systems.RenderCall;
import com.yuelao.controllingcrystal.network.CoalControllingCrystalPayload;
import com.yuelao.controllingcrystal.render.TextOverlay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;


import net.minecraft.entity.player.PlayerEntity;

import org.joml.Matrix4f;


import java.util.UUID;

import static com.yuelao.controllingcrystal.ControllingCrystal.LOGGER;

public class ControllingCrystalClient implements ClientModInitializer {

	private TextOverlay textOverlay;


	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		MinecraftClient client = MinecraftClient.getInstance();
		textOverlay = new TextOverlay(client);
		// 数据包处理-1级控制水晶
		ClientPlayNetworking.registerGlobalReceiver(CoalControllingCrystalPayload.ID, (payload, context) -> {
			context.client().execute(() -> {
				UUID player = payload.playerUUID();
				PlayerEntity playerEntity = client.world.getPlayerByUuid(player);


				LOGGER.info(playerEntity.getDisplayName().toString());

				textOverlay.setMessage(playerEntity.getDisplayName().toString(),1000);


			});
		});

		//渲染回调
		HudRenderCallback.EVENT.register((drawContext,rendertickCounter) ->
		{
			//LOGGER.info("");
			Matrix4f Matrices = drawContext.getMatrices().peek().getPositionMatrix();
			textOverlay.render(Matrices,
					MinecraftClient.getInstance().getWindow().getScaledWidth(),
					MinecraftClient.getInstance().getWindow().getScaledHeight());

		});

	}

}