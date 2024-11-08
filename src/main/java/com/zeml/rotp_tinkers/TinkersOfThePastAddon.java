package com.zeml.rotp_tinkers;


import com.github.standobyte.jojo.JojoMod;
import com.zeml.rotp_tinkers.data.JojoLootTableProvider;
import com.zeml.rotp_tinkers.data.tags.FluidTagProvider;
import com.zeml.rotp_tinkers.fluids.JojoFluids;
import com.zeml.rotp_tinkers.modifiers.JojoModifiers;
import com.zeml.rotp_tinkers.shared.JojoBlockDeferredRegisterExtension;
import com.zeml.rotp_tinkers.shared.JojoCommons;
import com.zeml.rotp_tinkers.shared.JojoMaterials;
import com.zeml.rotp_tinkers.data.tags.BlockTagProvider;
import com.zeml.rotp_tinkers.data.tags.ItemTagProvider;
import com.zeml.rotp_tinkers.data.JojoRecipeProvider;
import com.zeml.rotp_tinkers.smeltery.data.JojoSmelteryRecipeProvider;
import com.zeml.rotp_tinkers.tools.data.shared.JojoTools;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.modifiers.Modifier;


@Mod(TinkersOfThePastAddon.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersOfThePastAddon {
    public static final String MOD_ID = "rotp_tinkers";
    public static TinkersOfThePastAddon instance;

    public static final Logger LOGGER = LogManager.getLogger();
    public static final JojoBlockDeferredRegisterExtension BLOCKS = new JojoBlockDeferredRegisterExtension(JojoMod.MOD_ID);
    public static final ItemDeferredRegisterExtension ITEMS  = new ItemDeferredRegisterExtension(JojoMod.MOD_ID);
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(JojoMod.MOD_ID);
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, JojoMod.MOD_ID);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, JojoMod.MOD_ID);

    public TinkersOfThePastAddon() {
        instance = this;
        initRegisters();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(new JojoCommons());
        modEventBus.register(new JojoMaterials());
        modEventBus.register(new JojoFluids());
        modEventBus.register(new JojoModifiers());
        modEventBus.register(new JojoTools());


        MinecraftForge.EVENT_BUS.register(this);

    }

    public static ResourceLocation getResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }


    public static void initRegisters() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        FLUIDS.register(bus);
        RECIPE_SERIALIZERS.register(bus);
        MODIFIERS.register(bus);

    }

    @SubscribeEvent
    static void gatherData(final GatherDataEvent event) {
        if (event.includeServer()) {
            DataGenerator datagenerator = event.getGenerator();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            BlockTagProvider blockTagProvider = new BlockTagProvider(datagenerator, existingFileHelper);
            datagenerator.addProvider(blockTagProvider);
            datagenerator.addProvider(new ItemTagProvider(datagenerator, blockTagProvider, existingFileHelper));
            datagenerator.addProvider(new JojoRecipeProvider(datagenerator));
            datagenerator.addProvider(new JojoSmelteryRecipeProvider(datagenerator));
            datagenerator.addProvider(new JojoLootTableProvider(datagenerator));
            datagenerator.addProvider(new FluidTagProvider(datagenerator, existingFileHelper));
        }
    }

}
