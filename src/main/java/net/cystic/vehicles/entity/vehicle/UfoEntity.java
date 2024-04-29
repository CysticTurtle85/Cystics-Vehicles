package net.cystic.vehicles.entity.vehicle;

import net.cystic.vehicles.CysticsVehicles;
import net.cystic.vehicles.CysticsVehiclesClient;
import net.cystic.vehicles.entity.VehicleEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class UfoEntity extends VehicleEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean pressingLeft;
    private boolean pressingRight;
    private boolean pressingForward;
    private boolean pressingBack;
    private boolean pressingUp;
    private boolean pressingDown;

    public UfoEntity(EntityType<? extends VehicleEntity> entityType, World world) {
        super(entityType, world);
    }

    /*public static DefaultAttributeContainer.Builder setAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }
     */

    public void setInputs(boolean pressingLeft, boolean pressingRight, boolean pressingForward, boolean pressingBack, boolean pressingUp, boolean pressingDown) {
        this.pressingLeft = pressingLeft;
        this.pressingRight = pressingRight;
        this.pressingForward = pressingForward;
        this.pressingBack = pressingBack;
        this.pressingUp = pressingUp;
        this.pressingDown = pressingDown;
    }

    @Override
    public void tick() {
        super.tick();
        if (pressingUp) {
            this.setNoGravity(true);
            CysticsVehicles.LOGGER.info("gravity set to false");
            this.addVelocity(0, 0.1, 0);
            this.move(MovementType.SELF, this.getVelocity());
        } else {
            this.setNoGravity(false);
            CysticsVehicles.LOGGER.info("gravity set to true");
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        //this.setNoGravity(true);
        //CysticsVehicles.LOGGER.info("gravity set to false");

        return super.interactMob(player, hand);
    }

    @Override
    public void dismountVehicle() {
        super.dismountVehicle();

        //this.setNoGravity(false);
        //CysticsVehicles.LOGGER.info("gravity set to true");
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        /*if(tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ufo.walk", Animation.LoopType.LOOP));
        }*/

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }
}
