package net.feltmc.neoforge.patches.mixin.client.gui.components;

import net.feltmc.neoforge.patches.interfaces.Button_BuilderInterface;
import net.minecraft.client.gui.components.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Button.Builder.class)
public class Button_BuilderMixin implements Button_BuilderInterface {
    public Button build(java.util.function.Function<Button.Builder, Button> builder) {
        return builder.apply((Button.Builder)(Object) this);
    }

    @Inject(method = "build", cancellable = true, at = @At("HEAD"))
    private void overrideBuild(CallbackInfoReturnable<Button> cir) {
        cir.setReturnValue(new Button((Button.Builder)(Object) this));
    }
}
