package com.angelsensual.abg;

import com.angelsensual.abg.screen.ModScreenHandler;
import com.angelsensual.abg.screen.custom.AmmunitionTableScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class AllAboutGunsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandler.AMMUNITION_TABLE_SCREEN_HANDLER, AmmunitionTableScreen::new);
    }
}
