package com.zeml.rotp_tinkers.data.tags;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.shared.JojoMaterials;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.MetalItemObject;

import java.util.function.Consumer;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagProvider, JojoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.addMaterials();
        this.addSmeltery();
    }

    private void addMaterials() {
        addMetalTags(JojoMaterials.meteoric);
        addMetalTags(JojoMaterials.meteor);
    }





    private void addSmeltery() {
        TagsProvider.Builder<Item> goldCasts = this.tag(TinkerTags.Items.GOLD_CASTS);
        TagsProvider.Builder<Item> sandCasts = this.tag(TinkerTags.Items.SAND_CASTS);
        TagsProvider.Builder<Item> redSandCasts = this.tag(TinkerTags.Items.RED_SAND_CASTS);
        TagsProvider.Builder<Item> singleUseCasts = this.tag(TinkerTags.Items.SINGLE_USE_CASTS);
        TagsProvider.Builder<Item> multiUseCasts = this.tag(TinkerTags.Items.MULTI_USE_CASTS);
        Consumer<CastItemObject> addCast = cast -> {
            // tag based on material
            goldCasts.add(cast.get());
            sandCasts.add(cast.getSand());
            redSandCasts.add(cast.getRedSand());
            // tag based on usage
            singleUseCasts.addTag(cast.getSingleUseTag());
            this.tag(cast.getSingleUseTag()).add(cast.getSand(), cast.getRedSand());
            multiUseCasts.addTag(cast.getMultiUseTag());
            this.tag(cast.getMultiUseTag()).add(cast.get());
        };

        // Todo: Add casts for tool parts here

    }

    /**
     * Adds relevant tags for a metal object
     * @param metal  Metal object
     */
    private void addMetalTags(MetalItemObject metal) {
        this.tag(metal.getIngotTag()).add(metal.getIngot());
        this.tag(Tags.Items.INGOTS).addTag(metal.getIngotTag());
        this.tag(metal.getNuggetTag()).add(metal.getNugget());
        this.tag(Tags.Items.NUGGETS).addTag(metal.getNuggetTag());
        this.copy(metal.getBlockTag(), metal.getBlockItemTag());
    }
}
