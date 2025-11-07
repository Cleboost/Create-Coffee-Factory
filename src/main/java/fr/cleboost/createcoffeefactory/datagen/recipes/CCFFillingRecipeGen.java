package fr.cleboost.createcoffeefactory.datagen.recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.FillingRecipeGen;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.core.CCFFluids;
import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

public class CCFFillingRecipeGen extends FillingRecipeGen {
    GeneratedRecipe
    COFFEE_CUP = create("coffee_cup", b -> b
        .require(CCFItems.CUP.get())
        .require(CCFFluids.COFFEE.get(), 25)
        .output(CCFItems.COFFEE_CUP.get()));

    public CCFFillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateCoffeeFactory.MODID);
    }
}
