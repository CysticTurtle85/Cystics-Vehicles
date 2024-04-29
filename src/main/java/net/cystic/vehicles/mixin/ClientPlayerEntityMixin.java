package net.cystic.vehicles.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.cystic.vehicles.entity.vehicle.UfoEntity;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;

@Debug(export = true)
@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Shadow
    private boolean riding;

    @Shadow public Input input;

    @WrapOperation(method = "tickRiding", constant = @Constant(classValue = BoatEntity.class, ordinal = 0))
    private boolean updateRidingUfo(Object obj, Operation<Boolean> original){
        if (obj instanceof UfoEntity ufo) {
            ufo.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack, this.input.jumping, this.input.sneaking);
        }
        return original.call(obj);
    }
}
