package api.skies.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SkiesRegistry {
    private final String modId;
    private final DeferredRegister.Blocks blocks;
    private final DeferredRegister.Items items;
    private final DeferredRegister<CreativeModeTab> tabs;

    public SkiesRegistry(String modId) {
        this.modId = modId;
        this.blocks = DeferredRegister.createBlocks(modId);
        this.items = DeferredRegister.createItems(modId);
        this.tabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
    }

    /** Call once in your mod constructor. */
    public void register(IEventBus bus) {
        blocks.register(bus);
        items.register(bus);
        tabs.register(bus);
    }

    /** Registers a simple item. */
    public DeferredItem<Item> item(String name) {
        return items.registerSimpleItem(name);
    }

    /** Registers a simple block plus its block item. */
    public DeferredBlock<Block> block(String name) {
        return block(name, BlockBehaviour.Properties.of());
    }

    /** Registers a simple block with custom properties plus its block item. */
    public DeferredBlock<Block> block(String name, BlockBehaviour.Properties props) {
        DeferredBlock<Block> b = blocks.registerSimpleBlock(name, props);
        items.registerSimpleBlockItem(b);
        return b;
    }

    public String modId() {
        return modId;
    }
}
