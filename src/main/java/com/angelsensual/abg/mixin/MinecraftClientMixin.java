package com.angelsensual.abg.mixin;

import com.angelsensual.acl.item.custom.GunItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
    private void cancelAttackIfHoldingGun(CallbackInfoReturnable<Boolean> cir) {
        if (this.player != null) {
            Item heldItem = this.player.getMainHandStack().getItem();

            // DEBUG: Print what we are holding
            // System.out.println("Mixin doAttack: Holding " + heldItem.getClass().getName());

            if (heldItem instanceof GunItem) {
                // System.out.println("Mixin: Cancelling Attack!");
                cir.setReturnValue(false);
            }
        }
    }
}
