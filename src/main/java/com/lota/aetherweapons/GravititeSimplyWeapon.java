package com.lota.aetherweapons;
import net.sweenus.simplyswords.item.SimplySwordsSwordItem;
import com.aetherteam.aether.item.combat.abilities.weapon.GravititeWeapon;
import net.minecraft.world.item.Tier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GravititeSimplyWeapon extends SimplySwordsSwordItem implements GravititeWeapon{
    public GravititeSimplyWeapon(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        this.launchEntity(target, attacker);
        return super.hurtEnemy(stack, target, attacker);
    }

    
}
