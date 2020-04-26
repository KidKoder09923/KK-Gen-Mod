package net.kidkoder.genorator.init;

import net.kidkoder.genorator.tileentity.BlockSpawnEggGen;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static Block SPAWN_EGG_GENERATOR = null;
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(

                SPAWN_EGG_GENERATOR = new BlockSpawnEggGen()

        );
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {

            event.getRegistry().registerAll(

                    new BlockItem(SPAWN_EGG_GENERATOR, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("spawn_egg_gen")

            );


    }
}
