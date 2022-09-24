package au.net.euclid.red_spawner.mixin;

import net.minecraft.world.MobSpawnerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobSpawnerLogic.class)
public interface MobSpawnerLogicAccessor {
	@Accessor
	int getSpawnDelay();

	@Accessor("spawnDelay")
	public void setSpawnDelay(int spawnDelay);
}
