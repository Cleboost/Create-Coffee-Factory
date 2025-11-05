package fr.cleboost.createcoffeefactory;

import com.mojang.logging.LogUtils;

import fr.cleboost.createcoffeefactory.core.*;
import fr.cleboost.createcoffeefactory.datagen.CCFDatagen;
import fr.cleboost.createcoffeefactory.utils.CCFRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(CreateCoffeeFactory.MODID)
public class CreateCoffeeFactory {
    public static final String MODID = "createcoffeefactory";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CCFRegistrate REGISTRATE = CCFRegistrate.create(MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, MODID);
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CCFTab = REGISTRATE.object("create_coffee_factory")
            .defaultCreativeTab(tab -> tab.icon(CCFItems.LOGO::asStack))
            .register();


    public CreateCoffeeFactory(IEventBus modEventBus) {
        CCFLangs.register();
        REGISTRATE.registerEventListeners(modEventBus);
        CCFItems.register();
        CCFFluids.register();

        MENUS.register(modEventBus);

        

        modEventBus.addListener(CCFDatagen::gatherData);
    }
    
    @SubscribeEvent
    public static CCFRegistrate registrate() {
        return REGISTRATE;
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
