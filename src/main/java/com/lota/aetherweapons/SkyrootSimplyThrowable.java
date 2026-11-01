package com.lota.aetherweapons;
import net.sweenus.simplyswords.item.SimplySwordsThrowableItem;
import com.aetherteam.aether.item.combat.abilities.weapon.SkyrootWeapon;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;

public class SkyrootSimplyThrowable extends SimplySwordsThrowableItem implements SkyrootWeapon{
    public SkyrootSimplyThrowable(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }
}
