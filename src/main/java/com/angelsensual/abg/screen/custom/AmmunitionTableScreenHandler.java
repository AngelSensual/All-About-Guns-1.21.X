package com.angelsensual.abg.screen.custom;

import com.angelsensual.abg.block.entity.custom.AmmunitionTableBlockEntity;
import com.angelsensual.abg.screen.ModScreenHandler;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class AmmunitionTableScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final AmmunitionTableBlockEntity blockEntity;


    public AmmunitionTableScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(4));
    }

    public AmmunitionTableScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandler.AMMUNITION_TABLE_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 4);
        this.inventory = ((Inventory) blockEntity);
        this.blockEntity = (AmmunitionTableBlockEntity) blockEntity;
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(inventory, 0, 152, 86) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                AmmunitionTableScreenHandler.this.blockEntity.onCraft();
                AmmunitionTableScreenHandler.this.blockEntity.craftItem();
                super.onTakeItem(player, stack);
            }
        });

        this.addSlot(new Slot(inventory, 1, 44, 86));
        this.addSlot(new Slot(inventory, 2, 80, 86));
        this.addSlot(new Slot(inventory, 3, 116, 86));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot == 0) {
                if (!this.insertItem(originalStack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onTakeItem(player, originalStack);

                // Now loop for the REST
                while (true) {
                    // Update output slot to see if we can craft more
                    this.blockEntity.craftItem();
                    
                    if (!this.blockEntity.hasRecipe()) {
                        break;
                    }
                    
                    ItemStack nextResult = this.inventory.getStack(0);
                    if (nextResult.isEmpty()) break;
                    

                    ItemStack copyOfNext = nextResult.copy();
                    if (!this.insertItem(copyOfNext, 4, 40, true)) {
                        break;
                    }

                    this.blockEntity.onCraft();
                }
                return newStack;
            } 

            else if (invSlot < 4) {
                if (!this.insertItem(originalStack, 4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } 

            else {
                if (!this.insertItem(originalStack, 1, 4, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
            
            if (originalStack.getCount() == newStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, originalStack);
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.dropInventory(player, this.inventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 26 + l * 18, 122 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 26 + i * 18, 180));
        }
    }
}
