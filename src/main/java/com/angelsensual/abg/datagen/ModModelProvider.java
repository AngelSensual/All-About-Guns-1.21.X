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
        itemModelGenerator.register(ModItems.BULLET_CASING, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_BULLET, Models.GENERATED);

    }
}
