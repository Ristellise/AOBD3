package aobd.aobd3.Proxy;

import aobd.aobd3.Aobd3;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by joshw on 11/2/2017.
 */
public class ClientProxy extends CommonProxy {
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Aobd3.MOD_ID + ":" + id, "inventory"));
    }
}
