package net.cystic.vehicles.entity.client;

import net.cystic.vehicles.CysticsVehicles;
import net.cystic.vehicles.entity.vehicle.UfoEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class UfoModel extends GeoModel<UfoEntity> {
    @Override
    public Identifier getModelResource(UfoEntity animatable) {
        return new Identifier(CysticsVehicles.MOD_ID, "geo/ufo.geo.json");
    }

    @Override
    public Identifier getTextureResource(UfoEntity animatable) {
        return new Identifier(CysticsVehicles.MOD_ID, "textures/model/ufo.png");
    }

    @Override
    public Identifier getAnimationResource(UfoEntity animatable) {
        return new Identifier(CysticsVehicles.MOD_ID, "animations/ufo.animation.json");
    }

    @Override
    public void setCustomAnimations(UfoEntity animatable, long instanceId, AnimationState<UfoEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }

}
