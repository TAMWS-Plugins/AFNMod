package com.afns.tamws.mod.afn.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;

public class AFNEntityTypes {

    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, "afnmod");

    public static final RegistryObject<EntityType<DirtArrowEntity>> DIRT_ARROW = register("dirt_arrow", DirtArrowEntity::new);

    public static <T extends Entity> RegistryObject<EntityType<T>> register(String id, BiFunction<EntityType<T>, World, T> function) {
        EntityType<T> type = EntityType.Builder.create(function::apply, EntityClassification.MISC).size(0.5F, 1.0F).trackingRange(100).immuneToFire().build(id);
        return REGISTER.register(id, () -> type);
    }
}
