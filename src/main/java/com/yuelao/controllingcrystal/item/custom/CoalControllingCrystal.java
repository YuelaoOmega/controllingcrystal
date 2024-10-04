package com.yuelao.controllingcrystal.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.yuelao.controllingcrystal.ControllingCrystal.PlayerNames;

public class CoalControllingCrystal extends Item {
    public CoalControllingCrystal(Settings settings){
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Random random = new Random();
        ItemStack itemStack = user.getStackInHand(hand);

        if(world.isClient){
            return TypedActionResult.pass(itemStack);
        }

        int index = random.nextInt(PlayerNames.size());
        String LuckyPlayer = PlayerNames.get(index);



        itemStack.decrement(1);
        return TypedActionResult.success(itemStack);
    }


}
