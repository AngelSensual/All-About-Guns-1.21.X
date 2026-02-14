package com.angelsensual.abg.item;

import com.angelsensual.abg.AllAboutGuns;
import com.angelsensual.abg.item.custom.TestGun;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));

    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Settings()));

    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new Item.Settings()));

    public static final Item LAPIS_NUGGET = registerItem("lapis_nugget", new Item(new Item.Settings()));

    public static final Item QUARTZ_SHARD = registerItem("quartz_shard", new Item(new Item.Settings()));

    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new Item.Settings()));

    public static final Item FLINT_SHARD = registerItem("flint_shard", new Item(new Item.Settings()));

    public static final Item AMETHYST_FRAGMENT = registerItem("amethyst_fragment", new Item(new Item.Settings()));

    public static final Item BRASS_NUGGET = registerItem("brass_nugget", new Item(new Item.Settings()));

    public static final Item BRASS_INGOT = registerItem("brass_ingot", new Item(new Item.Settings()));

    public static final Item BULLET_CASING = registerItem("bullet_casing", new Item(new Item.Settings()));

    public static final Item IRON_BULLET = registerItem("iron_bullet", new Item(new Item.Settings()));

    public static final Item TEST_GUN = registerItem("test_gun", new TestGun(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AllAboutGuns.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AllAboutGuns.LOGGER.info("Registering Mod Items for " + AllAboutGuns.MOD_ID);
    }
}
