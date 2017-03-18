package aobd.aobditems;

import aobd.Aobd;
import aobd.Base.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class aobditems {
    public static ItemBase dust;
    public static void init() {
        dust = register(aobditems.dust.setCreativeTab(Aobd.aobdTab));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}
