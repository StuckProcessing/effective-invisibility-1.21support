package net.wondiws98.effectiveinvisibility.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class EffectiveInvisibilityMixin extends LivingEntity {
	protected EffectiveInvisibilityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}
	public double getAttackDistanceScalingFactor(@Nullable Entity entity) {
		double d = super.getAttackDistanceScalingFactor(entity);
		if (this.isInvisible()) {
			d = 0;
		}
        return d;
    }
}