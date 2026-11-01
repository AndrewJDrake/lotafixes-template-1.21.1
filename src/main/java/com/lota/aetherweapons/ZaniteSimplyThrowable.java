package com.lota.aetherweapons;
import net.sweenus.simplyswords.item.SimplySwordsThrowableItem;
import com.aetherteam.aether.item.combat.abilities.weapon.ZaniteWeapon;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ZaniteSimplyThrowable extends SimplySwordsThrowableItem implements ZaniteWeapon{
    public ZaniteSimplyThrowable(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    public static void onModifyAttributes(ItemAttributeModifierEvent event) {
        ItemAttributeModifiers modifiers = event.getDefaultModifiers();
        ItemStack itemStack = event.getItemStack();
        if (itemStack.getItem() instanceof ZaniteWeapon zaniteWeapon) {
            ItemAttributeModifiers.Entry attributeEntry = zaniteWeapon.increaseDamage(modifiers, itemStack);
            event.replaceModifier(attributeEntry.attribute(), attributeEntry.modifier(), attributeEntry.slot());
        }
    }
}
