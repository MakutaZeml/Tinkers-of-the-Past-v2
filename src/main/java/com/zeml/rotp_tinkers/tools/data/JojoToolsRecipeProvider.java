package com.zeml.rotp_tinkers.tools.data;

import com.zeml.rotp_tinkers.fluids.JojoFluids;
import com.zeml.rotp_tinkers.data.JojoBaseRecipeProvider;
import com.zeml.rotp_tinkers.tools.data.material.MaterialIds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import java.util.function.Consumer;

public class JojoToolsRecipeProvider extends JojoBaseRecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper {

    public JojoToolsRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        this.addToolBuildingRecipes(consumer);
        this.addPartRecipes(consumer);
        this.addMaterialsRecipes(consumer);
        this.addMaterialSmeltery(consumer);
    }

    @Override
    public String getName() {
        return "Tinker's Jojo Tool Recipes";
    }

    private void addToolBuildingRecipes(Consumer<IFinishedRecipe> consumer) {
        String folder = "tools/building/";


    }

    private void addPartRecipes(Consumer<IFinishedRecipe> consumer) {
        String partFolder = "tools/parts/";
        String castFolder = "smeltery/casts/";
        //partRecipes(consumer, DelightToolParts.naginataHead, DelightSmeltery.naginataHeadCast, 2, partFolder, castFolder);
    }

    private void addMaterialsRecipes(Consumer<IFinishedRecipe> consumer) {
        String folder = "tools/materials/";

        metalMaterialRecipe(consumer, MaterialIds.stand_arrow,   folder, "stand_arrow",   false);
        metalMaterialRecipe(consumer, MaterialIds.meteor,  folder, "meteor",  false);
    }

    private void addMaterialSmeltery(Consumer<IFinishedRecipe> consumer) {
        String folder = "tools/materials/";

        materialMeltingCasting(consumer, MaterialIds.stand_arrow, JojoFluids.molten_stand_arrow,   folder);
        materialMeltingCasting(consumer, MaterialIds.meteor,  JojoFluids.molten_meteor,  folder);
    }
}
