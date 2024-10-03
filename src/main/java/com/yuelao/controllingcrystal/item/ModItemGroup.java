package com.yuelao.controllingcrystal.item;

import com.yuelao.controllingcrystal.ControllingCrystal;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    //物品组-控制水晶
    public static final RegistryKey<ItemGroup> itemgroupControllingCrystal_key = RegistryKey.of(Registries.ITEM_GROUP.getKey()
            ,Identifier.of(ControllingCrystal.MOD_ID));
    public static final ItemGroup itemgroupControllingCrystal = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.NormalControllingCrystal))
            .displayName(Text.of("控制水晶"))
            .build();
    public static void registerItemGroup(){
        //O.o
        Registry.register(Registries.ITEM_GROUP,itemgroupControllingCrystal_key,itemgroupControllingCrystal);
        ItemGroupEvents.modifyEntriesEvent(itemgroupControllingCrystal_key).register(itemgroupControllingCrystal -> {
        itemgroupControllingCrystal.add(ModItems.CoalCrystal);
        itemgroupControllingCrystal.add(ModItems.BrokenControllingCrystal);
        itemgroupControllingCrystal.add(ModItems.NormalControllingCrystal);
        }
    );
    }






}
