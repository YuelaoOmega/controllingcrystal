package com.yuelao.controllingcrystal.item.custom;


import com.yuelao.controllingcrystal.network.CoalControllingCrystalPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


import java.util.Random;
import java.util.UUID;

import static com.yuelao.controllingcrystal.ControllingCrystal.Players;

public class CoalControllingCrystal extends Item {
    public CoalControllingCrystal(Settings settings){
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random random = new Random();
        ItemStack itemStack = user.getStackInHand(hand);

        int index = random.nextInt(Players.size());
        UUID LuckyPlayer = Players.get(index);


        if(world.isClient){
            return TypedActionResult.pass(itemStack);
        }

        CoalControllingCrystalPayload payload = new CoalControllingCrystalPayload(LuckyPlayer);
        for (UUID player_i: Players){
            ServerPlayNetworking.send((ServerPlayerEntity) world.getPlayerByUuid(player_i),payload);
        }




        itemStack.decrement(1);
        return TypedActionResult.success(itemStack);
    }




}
