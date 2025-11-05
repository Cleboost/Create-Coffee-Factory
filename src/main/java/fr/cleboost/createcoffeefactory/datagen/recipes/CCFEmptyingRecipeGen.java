package fr.cleboost.createcoffeefactory.datagen.recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.EmptyingRecipeGen;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.core.CCFFluids;
import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;

public class CCFEmptyingRecipeGen extends EmptyingRecipeGen {
    GeneratedRecipe
    COFFEE_CUP = create("coffee_cup", b -> b
        .require(Ingredient.of(CCFItems.COFFEE_CUP.get()))
        .output(CCFItems.CUP.get())
        .output(CCFFluids.COFFEE.get(), 25));

    public CCFEmptyingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateCoffeeFactory.MODID);
    }
}
