package net.kidkoder.genorator.tileentity;

import net.kidkoder.genorator.helper.NBTHelper;
import net.kidkoder.genorator.init.ModTileEntityTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class SpawnEggsGenTileEntity extends TileEntity implements ITickableTileEntity{

    public int tick;
    boolean inited = false;

    public SpawnEggsGenTileEntity(final TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public SpawnEggsGenTileEntity() {
        this(ModTileEntityTypes.SPAWN_EGG_GEN.get());
    }

    private void init() {
        inited = true;
        tick = 0;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvals", NBTHelper.toNBT(this));
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        CompoundNBT nbt = compound.getCompound("initvals");
        if(nbt != null) {
            this.tick = 0;
            inited = true;
            return;
        }
        init();

    }

    @Override
    public void tick() {
        if (!inited) init();
        if(tick == 3600) {
            tick = 0;
        } else tick++;
    }
}
