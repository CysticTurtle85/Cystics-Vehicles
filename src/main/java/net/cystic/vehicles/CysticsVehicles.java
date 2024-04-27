package net.cystic.vehicles;

import net.cystic.vehicles.entity.ModEntities;
import net.cystic.vehicles.entity.client.UfoRenderer;
import net.cystic.vehicles.entity.vehicle.UfoEntity;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.cystic.vehicles.entity.ModEntities.UFO;

public class CysticsVehicles implements ModInitializer {
	public static final String MOD_ID = "cysticsvehicles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(UFO, UfoEntity.createLivingAttributes());
	}
}