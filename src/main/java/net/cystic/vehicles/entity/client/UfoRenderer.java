package net.cystic.vehicles.entity.client;

import net.cystic.vehicles.CysticsVehicles;
import net.cystic.vehicles.entity.vehicle.UfoEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UfoRenderer extends GeoEntityRenderer<UfoEntity> {
    public UfoRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new UfoModel());
    }

    @Override
    public Identifier getTextureLocation(UfoEntity animatable) {
        return new Identifier(CysticsVehicles.MOD_ID, "textures/model/ufo.png");
    }

    @Override
    public void render(UfoEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
