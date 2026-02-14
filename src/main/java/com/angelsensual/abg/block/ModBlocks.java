package com.angelsensual.abg.block;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.block.custom.AmmunitionTableBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BRASS_BLOCK = registerBlock("brass_block",
            new Block(AbstractBlock.Settings.create().strength(3.5f,5f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER)));

    public static final Block AMMUNITION_TABLE = registerBlock("ammunition_table",
            new AmmunitionTableBlock(AbstractBlock.Settings.create().strength(2.5f,2.5f)
                    .requiresTool().sounds(BlockSoundGroup.WOOD)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AllAboutGuns.MOD_ID + ":" + name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AllAboutGuns.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        AllAboutGuns.LOGGER.info("Registering Mod Blocks for " + AllAboutGuns.MOD_ID);
    }
}
