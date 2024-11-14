package io.github.ticua07.stringduperfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TripwireHookBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

// code from https://github.com/WinExp/DumpedCarpetAddition/blob/1.21.3/src/main/java/com/github/winexp/dumpedcarpetaddition/mixins/largeOakGenerationFix/TripwireHookBlockMixin.java

@Mixin(TripwireHookBlock.class)
public abstract class TripwireHookBlockMixin {
    @WrapOperation(
            method = "update",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"),
            slice = @Slice(
                    from = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;", ordinal = 1)
            )
    )
    private static boolean reintroduceStringDuper(BlockState instance, Block block, Operation<Boolean> original) {
        return true;
    }
}
