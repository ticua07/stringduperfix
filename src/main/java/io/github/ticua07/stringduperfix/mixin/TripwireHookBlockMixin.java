package io.github.ticua07.stringduperfix.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.TripWireHookBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TripWireHookBlock.class)
public abstract class TripwireHookBlockMixin {

    @WrapOperation(
            method = "calculateState",
            at = @At(
                    value = "INVOKE",
                    //target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z",
                    ordinal = 3
            )
    )
    private static boolean reintroduceStringDuper(BlockState instance, Object o, Operation<Boolean> original) {
        return true;
    }
}