package com.zeml.rotp_tinkers.shared;

import com.zeml.rotp_tinkers.shared.data.JojoCommonRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import slimeknights.tconstruct.common.TinkerModule;
import slimeknights.tconstruct.common.recipe.RecipeCacheInvalidator;

public class JojoCommons {

    public JojoCommons() {
        MinecraftForge.EVENT_BUS.addListener(RecipeCacheInvalidator::onReloadListenerReload);
    }

    private static final Item.Properties BOOK = new Item.Properties()
            .tab(TinkerModule.TAB_GENERAL)
            .stacksTo(1);

    /* Book was removed
    public static final ItemObject<DelightBookItem> tinkersHandbook = TDelight.ITEMS
            .register("tinkers_handbook", () -> new DelightBookItem(BOOK, DelightBookItem.DelightBookType.TINKERS_HANDBOOK));
    */
    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        if (event.includeServer()) {
            DataGenerator datagenerator = event.getGenerator();
            datagenerator.addProvider(new JojoCommonRecipeProvider(datagenerator));
        }
    }
}
