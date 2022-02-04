package me.devlisuu.synthesizer.mixin;

import me.devlisuu.synthesizer.gui.GuiManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {

    @Inject(method = "onUse",
            cancellable = true,
            at = @At(value = "INVOKE",
                shift = At.Shift.BEFORE,
                target = "Lnet/minecraft/block/BlockState;cycle(Lnet/minecraft/state/property/Property;)Ljava/lang/Object;"))
    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        ServerPlayerEntity splayer = (ServerPlayerEntity)player;
        if(splayer.isSneaking()) {
            if(GuiManager.openPlayGUI(splayer, state, world, pos)) {
                cir.setReturnValue(ActionResult.CONSUME);
            }
        }
    }
}
