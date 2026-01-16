package com.angelsensual.abg.item;

import com.angelsensual.abg.AllAboutGuns;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BRASS_NUGGET = registerItem("brass_nugget", new Item(new Item.Settings()));
    public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new Item.Settings()));
    public static final Item BULLET_CASING = registerItem("bullet_casing", new Item(new Item.Settings()));

    public static final Item IRON_BULLET = registerItem("iron_bullet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AllAboutGuns.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AllAboutGuns.LOGGER.info("Registering Mod Items for " + AllAboutGuns.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BRASS_INGOT);
            entries.add(BRASS_NUGGET);
        });
    }

}
