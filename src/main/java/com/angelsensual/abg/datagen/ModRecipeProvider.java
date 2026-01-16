package com.angelsensual.abg.datagen;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.block.ModBlocks;
import com.angelsensual.abg.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;



public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BRASS_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRASS_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BRASS_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.BRASS_INGOT)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.BRASS_NUGGET)
                .criterion(hasItem(ModItems.BRASS_NUGGET), conditionsFromItem(ModItems.BRASS_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_nugget"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMMUNITION_TABLE)
                .pattern("BB")
                .pattern("PP")
                .pattern("PP")
                .input('B', ModItems.BRASS_INGOT)
                .input('P', ItemTags.PLANKS)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT, 9)
                .input(ModBlocks.BRASS_BLOCK)
                .criterion(hasItem(ModBlocks.BRASS_BLOCK), conditionsFromItem(ModBlocks.BRASS_BLOCK))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT, 9)
                .input(Items.COPPER_INGOT,2)
                .input(Items.GOLD_INGOT,2)
                .criterion(hasItem(ModBlocks.BRASS_BLOCK), conditionsFromItem(ModBlocks.BRASS_BLOCK))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_NUGGET, 9)
                .input(ModItems.BRASS_INGOT)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BULLET_CASING, 8)
                .input(ModItems.BRASS_NUGGET)
                .criterion(hasItem(ModItems.BRASS_NUGGET), conditionsFromItem(ModItems.BRASS_NUGGET))
                .offerTo(exporter);
    }
}
