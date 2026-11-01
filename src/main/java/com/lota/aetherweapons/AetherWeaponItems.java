package com.lota.aetherweapons;

import com.aetherteam.aether.item.combat.AetherItemTiers;
import com.lota.fixes.LotAFixes; // your main mod class, wherever MODID lives
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweenus.simplyswords.config.Config;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;

public final class AetherWeaponItems {
    private static final float SKYROOT_MODIFIER = 0.0F;

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LotAFixes.MODID);

    public static final DeferredItem<SkyrootSimplyWeapon> SKYROOT_LONGSWORD =
            ITEMS.register("skyroot_longsword", () -> new SkyrootSimplyWeapon(
                    AetherItemTiers.SKYROOT,
                    new Item.Properties().attributes(SwordItem.createAttributes(
                            AetherItemTiers.SKYROOT,
                            (int) (SKYROOT_MODIFIER
                                    + Config.weaponAttribute.typeDamageModifier.longsword_damageModifier),
                            Config.weaponAttribute.typeAttackSpeed.longsword_attackSpeed))));

    public static void addToCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(SKYROOT_LONGSWORD);
        }
    }

    private AetherWeaponItems() {}
}
