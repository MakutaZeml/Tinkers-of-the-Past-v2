package com.zeml.rotp_tinkers.shared.data;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.shared.JojoMaterials;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import slimeknights.tconstruct.shared.data.CommonRecipeProvider;

import java.util.function.Consumer;

public class JojoCommonRecipeProvider extends CommonRecipeProvider {

    public JojoCommonRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "Tinker's Delight Common Recipes";
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        this.addMaterialRecipes(consumer);
    }

    @Override
    public String getModId() {
        return JojoMod.MOD_ID;
    }

    private void addMaterialRecipes(Consumer<IFinishedRecipe> consumer) {
        String folder = "common/materials/";

        metalCrafting(consumer, JojoMaterials.meteoric, folder);
        metalCrafting(consumer, JojoMaterials.meteor, folder);
    }
}
