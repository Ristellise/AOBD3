package aobd.Proxy;

import aobd.Aobd;
import aobd.aobditems.aobditems;
import aobd.libs.Config;
import aobd.libs.Utils;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Aobd.MOD_ID + ":" + id, "inventory"));
        if (Config.DebugMode) {
            Utils.Logger(2,"Item: " + item + " meta: " + meta + "id: " + id);
        }

    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerColorsHandlers() {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(
                new IItemColor() {
                    @Override
                    @ParametersAreNonnullByDefault
                    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                        if (tintIndex == 1) {
                            return EnumDyeColor.byDyeDamage(stack.getMetadata()).getMapColor().colorValue;
                        }
                        return 0xFFFFFF;
                    }
                }, aobditems.dust);
    }

}
