package aobd.aobd.Proxy;

import aobd.aobd.Aobd;
import aobd.aobd.aobditems.aobditems;
import aobd.aobd.libs.Config;
import aobd.aobd.libs.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
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
    public void registerColorsHandlers()
    {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(
                new IItemColor() {
                    @Override
                    public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                        if (tintIndex == 1) {
                            return EnumDyeColor.byDyeDamage(stack.getMetadata()).getMapColor().colorValue;
                        }
                        return 0xFFFFFF;
                    }
                }, aobditems.dust);
    }
}
