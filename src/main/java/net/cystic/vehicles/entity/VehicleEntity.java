package net.cystic.vehicles.entity;

import net.cystic.vehicles.CysticsVehicles;
import net.cystic.vehicles.CysticsVehiclesClient;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;

public class VehicleEntity extends AnimalEntity {

    protected VehicleEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.hasPassengers()) {
            player.startRiding(this);

            return super.interactMob(player, hand);
        }

        return super.interactMob(player, hand);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    public void travel(Vec3d pos) {
        if (this.isAlive()) {
            if (this.hasPassengers()) {
                LivingEntity passenger = (LivingEntity)getControllingPassenger();
                this.prevYaw = getYaw();
                this.prevPitch = getPitch();

                setYaw(passenger.getYaw());
                setPitch(passenger.getPitch() * 0.5f);
                setRotation(getYaw(), getPitch());

                this.bodyYaw = this.getYaw();
                this.headYaw = this.bodyYaw;
                float x = passenger.sidewaysSpeed * 0.5F;
                float z = passenger.forwardSpeed;
                float y = passenger.upwardSpeed;

                if (z <= 0)
                    z *= 0.25f;

                this.setMovementSpeed(0.3f);
                super.travel(new Vec3d(x, y, z));
            }
        }
    }

    @Override
    public void updatePassengerPosition(Entity entity, PositionUpdater moveFunction) {
        if (entity instanceof LivingEntity passenger) {
            moveFunction.accept(entity, getX(), getY() - 0.2f, getZ());

            this.prevPitch = passenger.prevPitch;
        }
    }

    @Override
    public boolean isLogicalSideForUpdatingMovement() {
        return true;
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
