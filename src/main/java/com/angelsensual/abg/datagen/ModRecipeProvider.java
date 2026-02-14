package com.angelsensual.abg.datagen;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.block.ModBlocks;
import com.angelsensual.abg.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AMMUNITION_TABLE)
                .pattern("BB")
                .pattern("PP")
                .pattern("PP")
                .input('B', ModItems.BRASS_INGOT)
                .input('P', ItemTags.PLANKS)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(exporter);

        //BRASS (ingot from gold and copper)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT, 4)
                .input(Items.COPPER_INGOT,2)
                .input(Items.GOLD_INGOT,2)
                .criterion(hasItem(ModBlocks.BRASS_BLOCK), conditionsFromItem(ModBlocks.BRASS_BLOCK))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_ingots"));

        //BRASS (block from ingots)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BRASS_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.BRASS_INGOT)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .offerTo(exporter);

        //BRASS (ingot from nuggets)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.BRASS_NUGGET)
                .criterion(hasItem(ModItems.BRASS_NUGGET), conditionsFromItem(ModItems.BRASS_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_nugget"));

        //BRASS (ingot from blocks)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_INGOT, 9)
                .input(ModBlocks.BRASS_BLOCK)
                .criterion(hasItem(ModBlocks.BRASS_BLOCK), conditionsFromItem(ModBlocks.BRASS_BLOCK))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "brass_ingot_from_block"));

        //BRASS (nugget from ingot)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRASS_NUGGET, 9)
                .input(ModItems.BRASS_INGOT)
                .criterion(hasItem(ModItems.BRASS_INGOT), conditionsFromItem(ModItems.BRASS_INGOT))
                .offerTo(exporter);

        //COPPER (nugget from ingot)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9)
                .input(Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        //COPPER (ingot from nugget)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COPPER_INGOT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.COPPER_NUGGET)
                .criterion(hasItem(ModItems.COPPER_NUGGET), conditionsFromItem(ModItems.COPPER_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "copper_ingot_from_nugget"));

        //DIAMOND (nugget from diamond)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_NUGGET, 9)
                .input(Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

        //DIAMOND (diamond from nugget)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.DIAMOND_NUGGET)
                .criterion(hasItem(ModItems.DIAMOND_NUGGET), conditionsFromItem(ModItems.DIAMOND_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "diamond_from_nugget"));

        //NETHERITE (nugget from ingot)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERITE_NUGGET, 9)
                .input(Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);

        //NETHERITE (ingot from nugget)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHERITE_INGOT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.NETHERITE_NUGGET)
                .criterion(hasItem(ModItems.NETHERITE_NUGGET), conditionsFromItem(ModItems.NETHERITE_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "netherite_ingot_from_nugget"));

        //LAPIS (nugget from ingot)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAPIS_NUGGET, 9)
                .input(Items.LAPIS_LAZULI)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter);

        //LAPIS (ingot from nugget)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LAPIS_LAZULI)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.LAPIS_NUGGET)
                .criterion(hasItem(ModItems.LAPIS_NUGGET), conditionsFromItem(ModItems.LAPIS_NUGGET))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "lapis_lazuli_from_nugget"));

        //EMERALD (shard from emerald)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_SHARD, 9)
                .input(Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter);

        //EMERALD (emerald from shard)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.EMERALD)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.EMERALD_SHARD)
                .criterion(hasItem(ModItems.EMERALD_SHARD), conditionsFromItem(ModItems.EMERALD_SHARD))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "emerald_from_shard"));

        //FLINT (shard from flint)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FLINT_SHARD, 9)
                .input(Items.FLINT)
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter);

        //FLINT (flint from shard)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.FLINT)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.FLINT_SHARD)
                .criterion(hasItem(ModItems.FLINT_SHARD), conditionsFromItem(ModItems.FLINT_SHARD))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "flint_from_shard"));

        //QUARTZ (shard from quartz)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.QUARTZ_SHARD, 9)
                .input(Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter);

        //QUARTZ (quartz from shard)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.QUARTZ)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.QUARTZ_SHARD)
                .criterion(hasItem(ModItems.QUARTZ_SHARD), conditionsFromItem(ModItems.QUARTZ_SHARD))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "quartz_from_shard"));

        //AMETHYST (fragment from amethyst)
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_FRAGMENT, 9)
                .input(Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        //AMETHYST (amethyst from fragment)
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.AMETHYST_SHARD)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.AMETHYST_FRAGMENT)
                .criterion(hasItem(ModItems.AMETHYST_FRAGMENT), conditionsFromItem(ModItems.AMETHYST_FRAGMENT))
                .offerTo(exporter, Identifier.of(AllAboutGuns.MOD_ID, "amethyst_from_fragment"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BULLET_CASING, 8)
                .input(ModItems.BRASS_NUGGET)
                .criterion(hasItem(ModItems.BRASS_NUGGET), conditionsFromItem(ModItems.BRASS_NUGGET))
                .offerTo(exporter);
    }
}
