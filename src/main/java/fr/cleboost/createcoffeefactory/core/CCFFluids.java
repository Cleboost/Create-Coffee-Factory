package fr.cleboost.createcoffeefactory.core;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;

public class CCFFluids {
    private static final CreateRegistrate REGISTRATE = CreateCoffeeFactory.registrate();

    public static final FluidEntry<VirtualFluid> COFFEE =
            REGISTRATE.virtualFluid("coffee")
                    .tag(AllTags.commonFluidTag("coffee"))
                    .lang("Coffee")
                    .register();

    public static void register() {
    }
}
