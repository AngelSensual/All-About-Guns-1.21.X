package com.angelsensual.abg.screen;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.screen.custom.AmmunitionTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandler {
    public static final ScreenHandlerType<AmmunitionTableScreenHandler> AMMUNITION_TABLE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(AllAboutGuns.MOD_ID, "ammunition_table_screen_handler"),
                    new ExtendedScreenHandlerType<>(AmmunitionTableScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers(){
        AllAboutGuns.LOGGER.info("Registering Screen Handlers for " + AllAboutGuns.MOD_ID);
    }
}
