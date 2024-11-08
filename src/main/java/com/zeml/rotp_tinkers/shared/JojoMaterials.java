package com.zeml.rotp_tinkers.shared;

import com.zeml.rotp_tinkers.TinkersOfThePastAddon;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import slimeknights.mantle.item.BlockTooltipItem;
import slimeknights.tconstruct.common.registration.MetalItemObject;

import javax.annotation.Nullable;
import java.util.function.Function;

import static slimeknights.tconstruct.common.TinkerModule.TAB_GENERAL;

public class JojoMaterials {
    protected static final Item.Properties DELIGHT_GENERAL_PROPS = new Item.Properties().tab(TAB_GENERAL);
    protected static final Function<Block,? extends BlockItem> GENERAL_TOOLTIP_BLOCK_ITEM = (b) -> new BlockTooltipItem(b, DELIGHT_GENERAL_PROPS);

    public static final MetalItemObject meteoric = TinkersOfThePastAddon.BLOCKS.registerMetal("meteoric", metalBuilder(MaterialColor.GOLD), GENERAL_TOOLTIP_BLOCK_ITEM, DELIGHT_GENERAL_PROPS);
    public static final MetalItemObject meteor = TinkersOfThePastAddon.BLOCKS.registerMetal("meteor",  metalBuilder(MaterialColor.TERRACOTTA_YELLOW), GENERAL_TOOLTIP_BLOCK_ITEM, DELIGHT_GENERAL_PROPS);

    protected static AbstractBlock.Properties metalBuilder(MaterialColor color) {
        return builder(Material.METAL, color, ToolType.PICKAXE, SoundType.METAL).requiresCorrectToolForDrops();
    }

    protected static AbstractBlock.Properties builder(Material material, MaterialColor color, @Nullable ToolType toolType, SoundType soundType) {
        return Block.Properties.of(material, color).harvestTool(toolType).sound(soundType);
    }
}
