package net.kidkoder.genorator.init;

import net.kidkoder.genorator.KKGeneratorsMod;
import net.kidkoder.genorator.tileentity.SpawnEggsGenTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, KKGeneratorsMod.MOD_ID);

    public static final RegistryObject<TileEntityType<SpawnEggsGenTileEntity>> SPAWN_EGG_GEN = TILE_ENTITY_TYPES.register("spawn_egg_gen", () -> TileEntityType.Builder.create(SpawnEggsGenTileEntity::new, BlockInit.SPAWN_EGG_GENERATOR).build(null));
}
