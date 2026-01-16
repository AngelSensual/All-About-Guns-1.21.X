package com.angelsensual.abg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public record AmmunitionTableRecipes(List<Ingredient> ingredients, ItemStack outputItem) implements Recipe<AmmunitionTableRecipesInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.addAll(this.ingredients);
        return list;
    }

    @Override
    public boolean matches(AmmunitionTableRecipesInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        if (ingredients.size() != 3) return false;

        return ingredients.get(0).test(input.getStackInSlot(0)) &&
               ingredients.get(1).test(input.getStackInSlot(1)) &&
               ingredients.get(2).test(input.getStackInSlot(2));
    }

    @Override
    public ItemStack craft(AmmunitionTableRecipesInput input, RegistryWrapper.WrapperLookup lookup) {
        return outputItem.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return outputItem;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.AMMUNITION_TABLE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.AMMUNITION_TABLE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<AmmunitionTableRecipes> {
        public static final MapCodec<AmmunitionTableRecipes> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(AmmunitionTableRecipes::ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(AmmunitionTableRecipes::outputItem)
        ).apply(inst, AmmunitionTableRecipes::new));

        public static final PacketCodec<RegistryByteBuf, AmmunitionTableRecipes> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()), AmmunitionTableRecipes::ingredients,
                        ItemStack.PACKET_CODEC, AmmunitionTableRecipes::outputItem,
                        AmmunitionTableRecipes::new);

        @Override
        public MapCodec<AmmunitionTableRecipes> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, AmmunitionTableRecipes> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
