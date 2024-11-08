package com.zeml.rotp_tinkers.smeltery.data;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.data.JojoBaseRecipeProvider;
import com.zeml.rotp_tinkers.shared.JojoMaterials;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.data.recipe.ICommonRecipeHelper;

import java.util.function.Consumer;

public class JojoSmelteryRecipeProvider extends JojoBaseRecipeProvider implements ICommonRecipeHelper {

    public JojoSmelteryRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getModId() {
        return JojoMod.MOD_ID;
    }

    @Override
    public ResourceLocation modResource(String name) {
        return new ResourceLocation("tdelight", name);
    }

    @Override
    public String getName() {
        return "Tinker's Delight Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        this.addMaterialRecipes(consumer);
    }

    private void addMaterialRecipes(Consumer<IFinishedRecipe> consumer) {
        String folder = "common/materials/";

        metalCrafting(consumer, JojoMaterials.meteor, folder);
        metalCrafting(consumer, JojoMaterials.meteoric, folder);
    }
}
