package aobd.aobd.Proxy;

import aobd.aobd.Aobd;
import aobd.aobd.Misc.Config;
import aobd.aobd.Misc.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Aobd.MOD_ID + ":" + id, "inventory"));
        if (Config.DebugMode) {
            Utils.Logger(2,"Item: " + item + " meta: " + meta + "id: " + id);
        }

    }
}
