package fr.cleboost.createcoffeefactory.integration.jei;

import javax.annotation.Nonnull;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;

public class CCFJeiPlugin implements IModPlugin {
    private static final ResourceLocation ID = ResourceLocation.tryBuild(CreateCoffeeFactory.MODID, "plugin");
    private static IJeiRuntime runtime;

    
    public static IJeiRuntime getRuntime() {
        return runtime;
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime runtime) {
        CCFJeiPlugin.runtime = runtime;
    }
}
