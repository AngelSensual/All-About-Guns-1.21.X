package com.angelsensual.abg.item;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
        public static final ItemGroup ABG_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(AllAboutGuns.MOD_ID, "abg_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BRASS_INGOT))
                        .displayName(Text.translatable("itemgroup.all-about.guns.abg_items"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BRASS_BLOCK);
                            entries.add(ModItems.BRASS_INGOT);
                            entries.add(ModItems.BRASS_NUGGET);
                            entries.add(ModItems.BULLET_CASING);
                            entries.add(ModBlocks.AMMUNITION_TABLE);
                            entries.add(ModItems.IRON_BULLET);
                        }).build());

        public  static void registerItemGroups(){
            AllAboutGuns.LOGGER.info("Registering Item Groups for " + AllAboutGuns.MOD_ID);
        }
}
