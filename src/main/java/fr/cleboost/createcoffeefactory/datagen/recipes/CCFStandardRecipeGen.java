package fr.cleboost.createcoffeefactory.datagen.recipes;

import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class CCFStandardRecipeGen extends RecipeProvider {
    public CCFStandardRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void buildRecipes(@Nonnull RecipeOutput consumer) {
        SimpleCookingRecipeBuilder.smoking(
                        Ingredient.of(CCFItems.COFFEE_BEAN),
                        RecipeCategory.FOOD,
                        CCFItems.COFFEE_BEAN_ROASTED,
                        0.35f,
                        100)
                .unlockedBy("has_coffee_beans", has(CCFItems.COFFEE_BEAN))
                .save(consumer, "coffee_beans_roasted");
    }
}