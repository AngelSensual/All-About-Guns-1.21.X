package com.angelsensual.abg.block.entity;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.block.ModBlocks;
import com.angelsensual.abg.block.entity.custom.AmmunitionTableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<AmmunitionTableBlockEntity> AMMUNITION_TABLE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AllAboutGuns.MOD_ID, "ammunition_table_be"),
                    BlockEntityType.Builder.create(AmmunitionTableBlockEntity::new, ModBlocks.AMMUNITION_TABLE).build(null));

    public static void registerBlockEntities() {
        AllAboutGuns.LOGGER.info("Registering Block Entities for " + AllAboutGuns.MOD_ID);
    }
}
