package net.cystic.vehicles;

import net.cystic.vehicles.entity.ModEntities;
import net.cystic.vehicles.entity.client.UfoRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import static net.cystic.vehicles.entity.ModEntities.UFO;

public class CysticsVehiclesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(UFO, UfoRenderer::new);
    }
}
