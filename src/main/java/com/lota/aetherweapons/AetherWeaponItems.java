package com.lota.aetherweapons;

import java.util.EnumMap;
import java.util.Map;

import com.lota.fixes.LotAFixes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;

public final class AetherWeaponItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LotAFixes.MODID);

    public static final Map<AetherMaterial, Map<WeaponType, DeferredItem<Item>>> WEAPONS =
        new EnumMap<>(AetherMaterial.class);

    static {
    for (AetherMaterial material : AetherMaterial.values()) {
        Map<WeaponType, DeferredItem<Item>> byType = new EnumMap<>(WeaponType.class);
        for (WeaponType type : WeaponType.values()) {
            byType.put(type, ITEMS.register(material.id + "_" + type.id, () -> {
                Item.Properties props = new Item.Properties().attributes(SwordItem.createAttributes(
                        material.tier(),
                        (int) (material.modifier() + type.damage()),
                        type.speed()));
                if (material.fireResistant) props.fireResistant();
                return material.create(type, props);
            }));
        }
        WEAPONS.put(material, byType);
    }
}

    public static void addToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            WEAPONS.values().forEach(byType -> byType.values().forEach(event::accept));
        }
    }

    private AetherWeaponItems() {}
}
