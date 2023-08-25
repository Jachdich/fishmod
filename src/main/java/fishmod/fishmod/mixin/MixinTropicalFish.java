package fishmod.fishmod.mixin;

import fishmod.fishmod.FishMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TropicalFishEntity.class)
public abstract class MixinTropicalFish extends SchoolingFishEntity {

    @Shadow public abstract int getTropicalFishVariant();

    public MixinTropicalFish(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void e(EntityType<? extends TropicalFishEntity> entityType, World world, CallbackInfo ci) {
    }

    public void tick() {
        super.tick();
        //return variety.getShape() & 255 | (variety.getPattern() & 255) << 8 | (baseColor.getId() & 255) << 16 | (patternColor.getId() & 255) << 24;
        int var = this.getTropicalFishVariant();
        String variantHR = FishMod.getNameFromVariant(var, true);
        this.setCustomName(Text.of(variantHR));
        this.setCustomNameVisible(true);
    }

}
