package com.lota.aetherweapons;

import java.util.function.Supplier;
import net.sweenus.simplyswords.config.Config;

public enum WeaponType {
    LONGSWORD("longsword",     () -> Config.weaponAttribute.typeDamageModifier.longsword_damageModifier,   () -> Config.weaponAttribute.typeAttackSpeed.longsword_attackSpeed,   false),
    TWINBLADE("twinblade",     () -> Config.weaponAttribute.typeDamageModifier.twinblade_damageModifier,   () -> Config.weaponAttribute.typeAttackSpeed.twinblade_attackSpeed,   false),
    RAPIER("rapier",           () -> Config.weaponAttribute.typeDamageModifier.rapier_damageModifier,      () -> Config.weaponAttribute.typeAttackSpeed.rapier_attackSpeed,      false),
    KATANA("katana",           () -> Config.weaponAttribute.typeDamageModifier.katana_damageModifier,      () -> Config.weaponAttribute.typeAttackSpeed.katana_attackSpeed,      false),
    SAI("sai",                 () -> Config.weaponAttribute.typeDamageModifier.sai_damageModifier,         () -> Config.weaponAttribute.typeAttackSpeed.sai_attackSpeed,         false),
    SPEAR("spear",             () -> Config.weaponAttribute.typeDamageModifier.spear_damageModifier,       () -> Config.weaponAttribute.typeAttackSpeed.spear_attackSpeed,       true),
    GLAIVE("glaive",           () -> Config.weaponAttribute.typeDamageModifier.glaive_damageModifier,      () -> Config.weaponAttribute.typeAttackSpeed.glaive_attackSpeed,      false),
    WARGLAIVE("warglaive",     () -> Config.weaponAttribute.typeDamageModifier.warglaive_damageModifier,   () -> Config.weaponAttribute.typeAttackSpeed.warglaive_attackSpeed,   false),
    CUTLASS("cutlass",         () -> Config.weaponAttribute.typeDamageModifier.cutlass_damageModifier,     () -> Config.weaponAttribute.typeAttackSpeed.cutlass_attackSpeed,     false),
    CLAYMORE("claymore",       () -> Config.weaponAttribute.typeDamageModifier.claymore_damageModifier,    () -> Config.weaponAttribute.typeAttackSpeed.claymore_attackSpeed,    false),
    GREATHAMMER("greathammer", () -> Config.weaponAttribute.typeDamageModifier.greathammer_damageModifier, () -> Config.weaponAttribute.typeAttackSpeed.greathammer_attackSpeed, false),
    GREATAXE("greataxe",       () -> Config.weaponAttribute.typeDamageModifier.greataxe_damageModifier,    () -> Config.weaponAttribute.typeAttackSpeed.greataxe_attackSpeed,    false),
    CHAKRAM("chakram",         () -> Config.weaponAttribute.typeDamageModifier.chakram_damageModifier,     () -> Config.weaponAttribute.typeAttackSpeed.chakram_attackSpeed,     false),
    SCYTHE("scythe",           () -> Config.weaponAttribute.typeDamageModifier.scythe_damageModifier,      () -> Config.weaponAttribute.typeAttackSpeed.scythe_attackSpeed,      false),
    HALBERD("halberd",         () -> Config.weaponAttribute.typeDamageModifier.halberd_damageModifier,     () -> Config.weaponAttribute.typeAttackSpeed.halberd_attackSpeed,     false);

    public final String id;
    private final Supplier<Float> damage;
    private final Supplier<Float> speed;
    public final boolean throwable;

    WeaponType(String id, Supplier<Float> damage, Supplier<Float> speed, boolean throwable) {
        this.id = id;
        this.damage = damage;
        this.speed = speed;
        this.throwable = throwable;
    }

    public float damage() { return damage.get(); }
    public float speed() { return speed.get(); }
}