package com.zeml.rotp_tinkers.smeltery;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.TinkersOfThePastAddon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.util.SupplierItemGroup;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class DelightSmeltery {
    public static final ItemGroup TAB_SMELTERY = new SupplierItemGroup(JojoMod.MOD_ID, "smeltery", () -> new ItemStack(TinkerSmeltery.smelteryController));

    private static final Item.Properties SMELTERY_PROPS = new Item.Properties().tab(TAB_SMELTERY);
    //private static final Function<Block,? extends BlockItem> TOOLTIP_BLOCK_ITEM = (b) -> new BlockTooltipItem(b, SMELTERY_PROPS);


}
