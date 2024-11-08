package com.zeml.rotp_tinkers.tools.data.material;

import com.github.standobyte.jojo.JojoMod;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class MaterialIds {
    public static final MaterialId meteor   = id("meteor");
    public static final MaterialId stand_arrow = id("stand_arrow");

    /**
     * Creates a new material ID
     * @param name  ID name
     * @return  Material ID object
     */
    private static MaterialId id(String name) {
        return new MaterialId(JojoMod.MOD_ID, name);
    }
}
