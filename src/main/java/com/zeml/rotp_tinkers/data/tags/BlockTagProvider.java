package com.zeml.rotp_tinkers.data.tags;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.shared.JojoMaterials;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.registration.MetalItemObject;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, JojoMod.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Tinkers Delight Block Tags";
    }

    @Override
    protected void addTags() {
        this.addCommon();
    }

    private void addCommon() {
        addMetalTags(JojoMaterials.meteor);
        addMetalTags(JojoMaterials.meteoric);
    }

    private void addMetalTags(MetalItemObject metal) {
        this.tag(metal.getBlockTag()).add(metal.get());
        this.tag(BlockTags.BEACON_BASE_BLOCKS).addTag(metal.getBlockTag());
        this.tag(Tags.Blocks.STORAGE_BLOCKS).addTag(metal.getBlockTag());
    }
}
