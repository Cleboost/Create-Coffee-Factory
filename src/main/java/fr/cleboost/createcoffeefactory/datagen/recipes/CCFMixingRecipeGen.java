package fr.cleboost.createcoffeefactory.datagen.recipes;

import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.core.CCFFluids;
import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CCFMixingRecipeGen extends MixingRecipeGen {
    GeneratedRecipe

    COFFEE = create("coffee", b -> b
            .require(CCFItems.COFFEE_POWDER)
            .require(CCFItems.COFFEE_POWDER)
            .require(CCFItems.COFFEE_POWDER)
            .require(Tags.Fluids.WATER, 25)
            .output(CCFFluids.COFFEE.get(),25)
            .requiresHeat(HeatCondition.HEATED)
    );

    public CCFMixingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateCoffeeFactory.MODID);
    }
}
