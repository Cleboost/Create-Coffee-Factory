package fr.cleboost.createcoffeefactory.datagen.recipes;

import java.util.concurrent.CompletableFuture;

import com.simibubi.create.api.data.recipe.MillingRecipeGen;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

public class CCFMillingRecipeGen extends MillingRecipeGen {
    GeneratedRecipe 
    
    COFFEE_POWDER = create("coffee_powder", b -> b
        .require(CCFItems.COFFEE_BEAN_ROASTED)
        .duration(200)
        .output(CCFItems.COFFEE_POWDER, 4)
    );

    public CCFMillingRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateCoffeeFactory.MODID);
    }
}
