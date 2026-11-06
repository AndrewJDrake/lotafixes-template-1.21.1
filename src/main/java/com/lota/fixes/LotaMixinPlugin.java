package com.lota.fixes;

import com.bawnorton.mixinsquared.MixinSquaredBootstrap;
import net.neoforged.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

// Mixin config plugin for lotafixes.mixins.json.
// - Starts MixinSquared.
// - Applies each compat fix only if the mod it patches is installed.
public class LotaMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        MixinSquaredBootstrap.init();
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith(".IPContainerOpenersFix")) {
            return isLoaded("ip_aeronautics");
        }
        if (mixinClassName.endsWith(".UrnDeathDisable")) {
            return isLoaded("lilis_pottery");
        }
        return true;
        
    }

    private static boolean isLoaded(String modId) {
        return LoadingModList.get().getModFileById(modId) != null;
    }

    // Required by IMixinConfigPlugin; nothing to do in these.
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}