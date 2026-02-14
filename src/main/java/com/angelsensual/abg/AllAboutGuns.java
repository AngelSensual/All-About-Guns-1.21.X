package com.angelsensual.abg;

import com.angelsensual.abg.block.ModBlocks;
import com.angelsensual.abg.block.entity.ModBlockEntities;
import com.angelsensual.abg.item.ModItemGroups;
import com.angelsensual.abg.item.ModItems;
import com.angelsensual.abg.recipe.ModRecipes;
import com.angelsensual.abg.screen.ModScreenHandler;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllAboutGuns implements ModInitializer {
	public static final String MOD_ID = "all-about-guns";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModBlockEntities.registerBlockEntities();

		ModScreenHandler.registerScreenHandlers();

		ModRecipes.registerRecipes();

	}
}