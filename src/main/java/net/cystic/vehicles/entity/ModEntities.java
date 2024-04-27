package net.cystic.vehicles.entity;

import net.cystic.vehicles.CysticsVehicles;
import net.cystic.vehicles.entity.vehicle.UfoEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<UfoEntity> UFO = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(CysticsVehicles.MOD_ID, "ufo"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, UfoEntity::new)
                    .dimensions(EntityDimensions.fixed(3f, 1f)).build());
}
