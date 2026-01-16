package com.angelsensual.abg.recipe;

import com.angelsensual.abg.AllAboutGuns;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<AmmunitionTableRecipes> AMMUNITION_TABLE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(AllAboutGuns.MOD_ID, "ammunition_table"),
                new AmmunitionTableRecipes.Serializer()
    );

    public static final RecipeType<AmmunitionTableRecipes> AMMUNITION_TABLE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(AllAboutGuns.MOD_ID, "ammunition_table"), new RecipeType<AmmunitionTableRecipes>() {
                @Override
                public String toString() { return "Ammunition Table"; }
            }
    );

    public static void registerRecipes() {
        AllAboutGuns.LOGGER.info("Registering Recipes for " + AllAboutGuns.MOD_ID);
    }

}
