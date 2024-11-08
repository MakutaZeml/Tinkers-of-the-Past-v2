package com.zeml.rotp_tinkers.modifiers;

import com.github.standobyte.jojo.item.StandArrowItem;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class StandArrowModifier extends SingleUseModifier {


    public StandArrowModifier() {
        super(0x7e6a30);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damageDealt) {


        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
