package fr.cleboost.createcoffeefactory.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.datagen.recipes.CCFStandardRecipeGen;

public class CCFDatagen {
    public static void gatherData(GatherDataEvent event) {
        if (!event.getMods().contains(CreateCoffeeFactory.MODID)) return;

        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new CCFStandardRecipeGen(packOutput, lookupProvider));

        if (event.includeServer()) {
            CCFRecipeProvider.registerAllProcessing(gen, packOutput, lookupProvider);
        }
    }
}
