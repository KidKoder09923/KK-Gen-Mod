package net.kidkoder.genorator.helper;

import net.kidkoder.genorator.tileentity.SpawnEggsGenTileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NBTHelper {

    public static CompoundNBT toNBT(Object o) {
        if(o instanceof ItemStack) {
            return writeItemStack((ItemStack)o);
        }
        if(o instanceof SpawnEggsGenTileEntity) {
            return writeSpawnEggsGen((SpawnEggsGenTileEntity)o);
        }

        return null;

    }

    private static CompoundNBT writeSpawnEggsGen(SpawnEggsGenTileEntity o) {
        CompoundNBT tag = new CompoundNBT();
        return tag;
    }

    private static CompoundNBT writeItemStack(ItemStack o) {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("count", o.getCount());
        tag.putString("item", o.getItem().getRegistryName().toString());
        tag.putByte("type", (byte)0);
        return tag;
    }

    @Nullable
    public static Object fromNBT(@Nonnull CompoundNBT compound) {
        switch (compound.getByte("type")) {
            case 0:
                return readItemStack(compound);
            default:
                return null;
        }
    }

    private static ItemStack readItemStack(CompoundNBT compound) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("item")));
        int count = compound.getInt("count");
        return new ItemStack(item, count);
    }

}
