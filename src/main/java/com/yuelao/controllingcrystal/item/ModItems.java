package com.yuelao.controllingcrystal.item;

import com.yuelao.controllingcrystal.ControllingCrystal;
import com.yuelao.controllingcrystal.item.custom.CoalControllingCrystal;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    //物品注册方法
    public static Item registerItem(Item item, String id){
        Identifier itemID = Identifier.of(ControllingCrystal.MOD_ID,id);
        Item registeredItem = Registry.register(Registries.ITEM,itemID,item);
        ControllingCrystal.LOGGER.info("registried a item");
        return registeredItem;
    }

    //供入口调用的初始化方法
    public static void intiialize(){
        //noting >_<
    }

    public static final Item NormalControllingCrystal = registerItem(new Item(new Item.Settings()),"normal_controlling_crystal");
    public static final Item BrokenControllingCrystal = registerItem(new Item(new Item.Settings()),"broken_controlling_crystal");
    public static final Item CoalCrystal = registerItem(new CoalControllingCrystal(new Item.Settings()), "coal_controlling_crystal");
}
