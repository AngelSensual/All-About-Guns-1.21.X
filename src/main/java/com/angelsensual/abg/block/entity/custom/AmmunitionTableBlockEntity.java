package com.angelsensual.abg.block.entity.custom;

import com.angelsensual.abg.block.entity.ImplementedInventory;
import com.angelsensual.abg.block.entity.ModBlockEntities;
import com.angelsensual.abg.recipe.AmmunitionTableRecipes;
import com.angelsensual.abg.recipe.AmmunitionTableRecipesInput;
import com.angelsensual.abg.recipe.ModRecipes;
import com.angelsensual.abg.screen.custom.AmmunitionTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AmmunitionTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT_1 = 1;
    private static final int INPUT_SLOT_2 = 2;
    private static final int INPUT_SLOT_3 = 3;
    private static final int OUTPUT_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;

    public AmmunitionTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.AMMUNITION_TABLE_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return 0;
            }

            @Override
            public void set(int index, int value) {

            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        craftItem();
    }

    public void craftItem() {
        Optional<RecipeEntry<AmmunitionTableRecipes>> recipe = getCurrentRecipe();

        if(recipe.isPresent()) {
            ItemStack result = recipe.get().value().outputItem().copy();
            this.setStack(OUTPUT_SLOT, result);
        } else {
            this.setStack(OUTPUT_SLOT, ItemStack.EMPTY);
        }
    }

    public void onCraft() {
        this.removeStack(INPUT_SLOT_1, 1);
        this.removeStack(INPUT_SLOT_2, 1);
        this.removeStack(INPUT_SLOT_3, 1);
    }

    public boolean hasRecipe() {
        return getCurrentRecipe().isPresent();
    }

    private Optional<RecipeEntry<AmmunitionTableRecipes>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager()
                .getFirstMatch(ModRecipes.AMMUNITION_TABLE_TYPE, new AmmunitionTableRecipesInput(inventory.get(INPUT_SLOT_1), inventory.get(INPUT_SLOT_2), inventory.get(INPUT_SLOT_3)), this.getWorld());
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("Ammunition Table");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AmmunitionTableScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

}
