package com.zeml.rotp_tinkers.fluids;

import com.zeml.rotp_tinkers.TinkersOfThePastAddon;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.ModelFluidAttributes;
import slimeknights.mantle.registration.object.FluidObject;

public class JojoFluids {
    public JojoFluids() {
        ForgeMod.enableMilkFluid();
    }

    public static final ResourceLocation MOLTEN_STILL = new ResourceLocation(TinkersOfThePastAddon.MOD_ID,
            "block/fluids/molten_metal_still");
    public static final ResourceLocation MOLTEN_FLOW = new ResourceLocation(TinkersOfThePastAddon.MOD_ID,
            "block/fluids/molten_metal_flowing");

    public static final FluidObject<ForgeFlowingFluid> molten_stand_arrow   = TinkersOfThePastAddon.FLUIDS.register("molten_stand_arrow",   moltenBuilder().temperature(1000).color(0xffdac352), Material.LAVA, 15);
    public static final FluidObject<ForgeFlowingFluid> molten_meteor = TinkersOfThePastAddon.FLUIDS.register("molten_meteor", moltenBuilder().temperature(1000).color(0xff7e6a30), Material.LAVA, 10);


    private static FluidAttributes.Builder moltenBuilder() {
        return FluidAttributes.builder(MOLTEN_STILL, MOLTEN_FLOW).density(2000).viscosity(10000).temperature(1000);
    }

}
