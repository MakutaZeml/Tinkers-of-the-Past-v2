package com.zeml.rotp_tinkers.modifiers;

import com.zeml.rotp_tinkers.TinkersOfThePastAddon;
import net.minecraftforge.fml.RegistryObject;

public class JojoModifiers {

    public static final RegistryObject<StandArrowModifier> stand_arrow = TinkersOfThePastAddon.MODIFIERS.register("stand_arrow", StandArrowModifier::new);
    public static final RegistryObject<MeteorModifier> meteor = TinkersOfThePastAddon.MODIFIERS.register("meteor", MeteorModifier::new);

    /** Internal modifiers */


}
