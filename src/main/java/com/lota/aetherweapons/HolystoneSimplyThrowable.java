package com.lota.aetherweapons;
import net.sweenus.simplyswords.item.SimplySwordsThrowableItem;
import com.aetherteam.aether.item.combat.abilities.weapon.HolystoneWeapon;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HolystoneSimplyThrowable extends SimplySwordsThrowableItem implements HolystoneWeapon{
    public HolystoneSimplyThrowable(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.dropAmbrosium(target, attacker);
        return super.hurtEnemy(stack, target, attacker);
    }
}
