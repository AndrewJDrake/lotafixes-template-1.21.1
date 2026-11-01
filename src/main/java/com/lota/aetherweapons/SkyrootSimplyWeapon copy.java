package com.lota.aetherweapons;
import net.sweenus.simplyswords.item.SimplySwordsSwordItem;
import com.aetherteam.aether.item.combat.abilities.weapon.SkyrootWeapon;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;

public class SkyrootSimplyWeapon extends SimplySwordsSwordItem implements SkyrootWeapon{
    public SkyrootSimplyWeapon(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }
}
