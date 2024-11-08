package com.zeml.rotp_tinkers.tools.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class MaterialDataProvider extends AbstractMaterialDataProvider {
    public MaterialDataProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    public String getName() {
        return "Tinker's Delight Materials";
    }

    @Override
    protected void addMaterials() {
        addMaterial(MaterialIds.meteor,   3, ORDER_SPECIAL, false, 0x7e6a30);
        addMaterial(MaterialIds.stand_arrow, 3, ORDER_SPECIAL, false, 0xdac352);
    }
}
