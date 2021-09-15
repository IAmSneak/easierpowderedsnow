package com.gmail.sneakdevs.easierpowdersnow.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(CauldronBlock.class)
public abstract class CauldronBlockMixin extends Block {
    public CauldronBlockMixin(Settings settings) {
        super(settings);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity.getType().equals(EntityType.SNOWBALL)) {
            Random random = new Random();
            if (random.nextInt(32) == 0){
                world.setBlockState(pos, Blocks.POWDER_SNOW_CAULDRON.getDefaultState());
            }
        }
    }
}