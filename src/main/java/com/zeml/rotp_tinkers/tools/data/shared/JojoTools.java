package com.zeml.rotp_tinkers.tools.data.shared;

import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.data.JojoRecipeProvider;
import com.zeml.rotp_tinkers.tools.data.JojoToolsRecipeProvider;
import com.zeml.rotp_tinkers.tools.data.material.MaterialDataProvider;
import com.zeml.rotp_tinkers.tools.data.material.MaterialStatsDataProvider;
import com.zeml.rotp_tinkers.tools.data.material.MaterialTraitsDataProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import slimeknights.mantle.util.SupplierItemGroup;
import slimeknights.tconstruct.library.utils.BlockSideHitListener;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.function.Supplier;

public class JojoTools {
    public JojoTools() {
        BlockSideHitListener.init();
    }

    /** Creative tab for all tool items */
    public static final ItemGroup TAB_TOOLS = new SupplierItemGroup(JojoMod.MOD_ID, "tools", () -> TinkerTools.pickaxe.get().getRenderTool());
    private static final Supplier<Item.Properties> TOOL = () -> new Item.Properties().tab(TAB_TOOLS);

    /** Tools & weapons */


    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        if (event.includeServer()) {
            DataGenerator generator = event.getGenerator();
            generator.addProvider(new JojoToolsRecipeProvider(generator));
            generator.addProvider(new JojoRecipeProvider(generator));
            MaterialDataProvider materials = new MaterialDataProvider(generator);
            generator.addProvider(materials);
            generator.addProvider(new MaterialStatsDataProvider(generator, materials));
            generator.addProvider(new MaterialTraitsDataProvider(generator, materials));
        }
    }
}
