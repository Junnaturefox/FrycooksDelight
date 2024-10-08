package com.uraneptus.frycooks_delight.data.server.recipe;

import com.uraneptus.frycooks_delight.core.other.tags.FCDItemTags;
import com.uraneptus.frycooks_delight.core.registry.FCDBlocks;
import com.uraneptus.frycooks_delight.core.registry.FCDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("SameParameterValue")
public class FCDRecipeProvider extends RecipeProvider {

    public FCDRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE).requires(FCDItems.CANOLA.get()).unlockedBy(getHasName(FCDItems.CANOLA.get()), has(FCDItems.CANOLA.get())).save(consumer);
        packableBlockRecipes(FCDItems.CANOLA, FCDBlocks.CANOLA_CRATE.get().asItem(), consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FCDItems.CANOLA.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), FCDItems.CANOLA_SEEDS.get(), 2).addResult(Items.YELLOW_DYE, 1).build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(FCDItems.CANOLA_OIL.get(), 1, 200, 1.0F, Items.GLASS_BOTTLE).addIngredient(FCDItems.CANOLA_SEEDS.get(), 3).unlockedBy(getHasName(FCDItems.CANOLA_SEEDS.get()), has(FCDItems.CANOLA_SEEDS.get())).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FCDBlocks.WILD_CANOLA.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), FCDItems.CANOLA_SEEDS.get(), 1).addResultWithChance(Items.YELLOW_DYE, 0.5F).build(consumer);
        packableBlockRecipes(FCDItems.LARD, FCDBlocks.LARD_BLOCK.get().asItem(), consumer);
        FryingRecipeBuilder.frying(FCDItems.FRIED_POTATO.get()).requires(Items.POTATO).save(consumer);
        FryingRecipeBuilder.frying(FCDItems.PLAIN_DONUT.get()).requires(ModItems.WHEAT_DOUGH.get()).save(consumer);
        FryingRecipeBuilder.frying(FCDItems.FRIED_CHICKEN_LEG.get()).requires(ModItems.CHICKEN_CUTS.get()).save(consumer, "_from_chicken_cuts");
        FryingRecipeBuilder.frying(FCDItems.FRIED_CHICKEN_LEG.get()).extraResult(FCDItems.BURNT_MORSEL.get()).requires(Items.CHICKEN).save(consumer, "_from_chicken");
        FryingRecipeBuilder.frying(FCDItems.FRIED_FISH_SLICE.get()).requires(FCDItemTags.FISH_SLICES).save(consumer, "_from_slice");
        FryingRecipeBuilder.frying(FCDItems.FRIED_FISH_SLICE.get()).extraResult(FCDItems.BURNT_MORSEL.get()).requires(FCDItemTags.HAS_FISH_SLICE).save(consumer, "_from_fish");
        FryingRecipeBuilder.frying(FCDItems.FRIED_ONION_RING.get(), 2).requires(ModItems.ONION.get()).save(consumer);
    }

    protected static void packableBlockRecipes(Supplier<? extends ItemLike> unpacked, ItemLike packed, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, packed).define('#', unpacked.get()).pattern("## ").pattern("## ")
                .unlockedBy(getHasName(unpacked.get()), has(unpacked.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, unpacked.get(), 4).requires(packed)
                .unlockedBy(getHasName(packed), has(packed)).save(consumer);
    }
}
