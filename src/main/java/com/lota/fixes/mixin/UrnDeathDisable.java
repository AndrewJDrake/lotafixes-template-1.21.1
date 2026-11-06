package com.lota.fixes.mixin;

import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Lili's Pottery turns any urn or amphora in a dying player's inventory into a death container:
// it places the urn and moves the whole inventory, armor and offhand into it before drops are built.
// That beats Gravestone and Keep Equipment, and the mod has no config to turn it off.
//
// UrnDeathHandler.onLivingDeath() bails out when findUrnSlot() returns -1 ("no urn carried"),
// so forcing -1 here disables the feature. Urns stay as normal decor blocks.
//
// @Pseudo + string target: Lili's Pottery doesn't need to be on the compile classpath.
// LotaMixinPlugin only applies this when lilis_pottery is installed.
@Pseudo
@Mixin(targets = "net.satisfy.lilis_pottery.core.event.UrnDeathHandler", remap = false)
public abstract class UrnDeathDisable {

    @Inject(method = "findUrnSlot", at = @At("HEAD"), cancellable = true, remap = false)
    private static void lota$noUrnDeath(ServerPlayer serverPlayer, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(-1);
    }
}