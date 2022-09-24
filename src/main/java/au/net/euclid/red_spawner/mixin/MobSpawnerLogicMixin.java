package au.net.euclid.red_spawner.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MobSpawnerLogic.class)
public class MobSpawnerLogicMixin {

	@Inject(method = "serverTick", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILEXCEPTION, cancellable = true)
	public void redSpawner$serverTick(ServerWorld world, BlockPos pos, CallbackInfo ci) {
		if (world.isReceivingRedstonePower(pos)) {
			// Set spawnDelay to 0, so it will immediately spawn when next redstone is off.
			((MobSpawnerLogicAccessor)(Object)this).setSpawnDelay(0);

			// Do not spawn while powered (cancel spawn check etc.).
			ci.cancel();
		}
	}
}
