package com.angelsensual.abg.datagen;

import com.angelsensual.abg.block.ModBlocks;
import com.angelsensual.abg.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        // BlockStateModelGenerator.BlockTexturePool texturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRASS_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRASS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMMUNITION_TABLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BRASS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRASS_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARTZ_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULLET_CASING, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_BULLET, Models.GENERATED);

    }
}
