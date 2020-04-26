package net.kidkoder.genorator.tileentity;

import net.kidkoder.genorator.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockSpawnEggGen extends Block {
    public BlockSpawnEggGen() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(10));
        setRegistryName("spawn_egg_gen");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.SPAWN_EGG_GEN.get().create();
    }
}
