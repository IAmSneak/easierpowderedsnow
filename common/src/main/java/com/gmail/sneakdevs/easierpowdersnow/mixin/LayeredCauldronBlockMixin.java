package com.gmail.sneakdevs.easierpowdersnow.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayeredCauldronBlock.class)
public class LayeredCauldronBlockMixin {
    @Inject(at = @At("HEAD"), method = "entityInside")
    private void easierpowderedsnow_entityInsideMixin(BlockState state, Level world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (!world.isClientSide() && entity.getType().equals(EntityType.SNOWBALL)) {
            if (world.random.nextInt(24) == 0){
                if (state.getValue(LayeredCauldronBlock.LEVEL) != 3) {
                    world.setBlockAndUpdate(pos, state.cycle(LayeredCauldronBlock.LEVEL));
                }
            }
        }
    }
}