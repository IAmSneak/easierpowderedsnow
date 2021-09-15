package com.gmail.sneakdevs.easierpowdersnow.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LeveledCauldronBlock.class)
public class LeveledCauldronBlockMixin {
    @Inject(at = @At("HEAD"), method = "onEntityCollision")
    private void init(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (!world.isClient && entity.getType().equals(EntityType.SNOWBALL)) {
            Random random = new Random();
            if (random.nextInt(32) == 0){
                if (state.get(LeveledCauldronBlock.LEVEL) != 3) {
                    world.setBlockState(pos, state.cycle(LeveledCauldronBlock.LEVEL));
                }
            }
        }
    }
}