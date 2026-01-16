package com.angelsensual.abg.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record AmmunitionTableRecipesInput (ItemStack itemStack1, ItemStack itemStack2, ItemStack itemStack3) implements RecipeInput {

    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> itemStack1;
            case 1 -> itemStack2;
            case 2 -> itemStack3;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int getSize() {
        return 3;
    }
}
