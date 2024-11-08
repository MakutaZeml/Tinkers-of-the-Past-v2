package com.zeml.rotp_tinkers.data.tags;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.fluids.JojoFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FluidObject;

public class FluidTagProvider extends FluidTagsProvider {

    public FluidTagProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, JojoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tagAll(JojoFluids.molten_meteor);
        tagAll(JojoFluids.molten_stand_arrow);
    }

    @Override
    public String getName() {
        return "Tinkers Delight Fluid TinkerTags";
    }

    /**
     * Tags this fluid using local tags
     */
    private void tagLocal(FluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
    }

    /**
     * Tags this fluid with local and forge tags
     */
    private void tagAll(FluidObject<?> fluid) {
        tagLocal(fluid);
        tag(fluid.getForgeTag()).addTag(fluid.getLocalTag());
    }
}
