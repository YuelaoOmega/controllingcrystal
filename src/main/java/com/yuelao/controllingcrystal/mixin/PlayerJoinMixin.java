package com.yuelao.controllingcrystal.mixin;

import com.yuelao.controllingcrystal.event.PlayerJoinCallback;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerManager.class)
public class PlayerJoinMixin {
	@Inject(at = @At(value = "TAIL"),method = "onPlayerConnect")
	private void onPlayerJoin(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo info){
		PlayerJoinCallback.EVENT.invoker().joinServer(player,player.getServer());
	}
}