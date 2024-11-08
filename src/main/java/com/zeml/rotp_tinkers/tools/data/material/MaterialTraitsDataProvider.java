package com.zeml.rotp_tinkers.tools.data.material;

import com.zeml.rotp_tinkers.modifiers.JojoModifiers;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class MaterialTraitsDataProvider extends AbstractMaterialTraitDataProvider {

    public MaterialTraitsDataProvider(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    protected void addMaterialTraits() {

        addDefaultTraits(MaterialIds.stand_arrow, JojoModifiers.stand_arrow.get());
        addDefaultTraits(MaterialIds.meteor,   JojoModifiers.meteor.get());
    }

    @Override
    public String getName() {
        return "Tinker's Delight Material Traits";
    }
}
