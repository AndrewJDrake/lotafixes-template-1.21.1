package com.lota.aetherweapons;

import com.aetherteam.aether.item.combat.AetherItemTiers;
import io.github.razordevs.deep_aether.init.DATiers;
import mielon.thesift.item.ModItems;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.sweenus.simplyswords.config.Config;
import net.sweenus.simplyswords.item.SimplySwordsSwordItem;
import net.sweenus.simplyswords.item.SimplySwordsThrowableItem;

public enum AetherMaterial {
    SKYROOT("skyroot",     () -> AetherItemTiers.SKYROOT,   () -> 0.0F,
            SkyrootSimplyWeapon::new,   SkyrootSimplyThrowable::new),
    HOLYSTONE("holystone", () -> AetherItemTiers.HOLYSTONE, () -> 0.0F,
            HolystoneSimplyWeapon::new, HolystoneSimplyThrowable::new),
    ZANITE("zanite",       () -> AetherItemTiers.ZANITE,
            () -> Config.weaponAttribute.materialDamageModifier.iron_damageModifier,
            ZaniteSimplyWeapon::new,    ZaniteSimplyThrowable::new),
    SKYJADE("skyjade",     () -> DATiers.SKYJADE,
            () -> Config.weaponAttribute.materialDamageModifier.gold_damageModifier,
            SkyjadeSimplyWeapon::new,   SkyjadeSimplyThrowable::new),
    GRAVITITE("gravitite", () -> AetherItemTiers.GRAVITITE,
            () -> Config.weaponAttribute.materialDamageModifier.diamond_damageModifier,
            GravititeSimplyWeapon::new, GravititeSimplyThrowable::new),
    STRATUS("stratus",     () -> DATiers.STRATUS,
            () -> Config.weaponAttribute.materialDamageModifier.netherite_damageModifier,
            GravititeSimplyWeapon::new, GravititeSimplyThrowable::new),
    SIFTITE("siftite", () -> ModItems.SIFTITE_TOOL_MATERIAL,
            () -> Config.weaponAttribute.materialDamageModifier.netherite_damageModifier,
            SimplySwordsSwordItem::new, SimplySwordsThrowableItem::new, true);

    public final String id;
    private final Supplier<Tier> tier;
    private final Supplier<Float> modifier;
    private final BiFunction<Tier, Item.Properties, Item> sword;
    private final BiFunction<Tier, Item.Properties, Item> throwable;
    public final boolean fireResistant;

    AetherMaterial(String id, Supplier<Tier> tier, Supplier<Float> modifier,
                   BiFunction<Tier, Item.Properties, Item> sword,
                   BiFunction<Tier, Item.Properties, Item> throwable) {
        this.id = id;
        this.tier = tier;
        this.modifier = modifier;
        this.sword = sword;
        this.throwable = throwable;
        this.fireResistant = false;
    }

    AetherMaterial(String id, Supplier<Tier> tier, Supplier<Float> modifier,
                   BiFunction<Tier, Item.Properties, Item> sword,
                   BiFunction<Tier, Item.Properties, Item> throwable,
                   boolean fireResistant) {
        this.id = id;
        this.tier = tier;
        this.modifier = modifier;
        this.sword = sword;
        this.throwable = throwable;
        this.fireResistant = fireResistant;
    }

    public Tier tier() { return tier.get(); }
    public float modifier() { return modifier.get(); }

    public Item create(WeaponType type, Item.Properties properties) {
        return (type.throwable ? throwable : sword).apply(tier(), properties);
    }
}