package com.lota.fixes.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

// The Immersive Portals Container Counter has a glitch that causes crashes on client. This mixin fixes
// it by skipping over the problem code on the client side.
@Mixin(value = ContainerOpenersCounter.class, priority = 1500)     // (Target the Vanilia Class, and execute after Immersiver Portals mixin.
public abstract class IPContainerOpenersFix {

    @TargetHandler(                                                   // Target Immersive Portals's mixin
        mixin = "qouteall.imm_ptl.core.mixin.common.container_gui.MixinContainerOpenersCounter",
        name = "getOpenCount"
    )
    @Inject(method = "@MixinSquared:Handler", at = @At("HEAD"), cancellable = true)  // Swaps in the Target Handler's discovery.
    private void lota$skipOnClient(Level level, BlockPos pos,                  // Same signature.
                                   CallbackInfoReturnable<List<Player>> cir,
                                   CallbackInfo ci) {                           // Grabs the Callback from Immersive Portals.
        if (level.getServer() == null) {
            ci.cancel();                                                       // Cancel that Callback if the Server doesn't exist.
        }
    }
}