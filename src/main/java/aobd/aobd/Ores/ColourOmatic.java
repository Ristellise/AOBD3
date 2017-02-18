package aobd.aobd.Ores;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by joshw on 18/2/2017.
 */
public class ColourOmatic {
    @SideOnly(Side.CLIENT)
    private static Color getColour(String oreName) {
        java.util.List<ItemStack> ores = OreDictionary.getOres("ingot" + oreName);
        if (ores.isEmpty())
            return null;

        Color colour = Ore.getDefaultOreColour(oreName);
        if (colour != null)
            return colour;

        Set<Color> colours = new LinkedHashSet<Color>();
        for (ItemStack stack : ores)
            try {
                BufferedImage texture = ImageIO.read(Minecraft.getMinecraft().getResourceManager().getResource(getIconResource(stack)).getInputStream());
                Color texColour = getAverageColour(texture);
                colours.add(texColour);
                for (int pass = 0; pass < stack.getItem().getRenderPasses(stack.getItemDamage()); pass++) {
                    int c = getStackColour(stack, pass);
                    if (c != 0xFFFFFF) {
                        colours.add(new Color(c));
                        colours.remove(texColour);
                    }
                }
            } catch (Exception e) {
                continue;
            }

        float red = 0;
        float green = 0;
        float blue = 0;
        for (Color c : colours) {
            red += c.getRed();
            green += c.getGreen();
            blue += c.getBlue();
        }
        float count = colours.size();
        return new Color((int) (red / count), (int) (green / count), (int) (blue / count));
    }
    private static String getIconName(ItemStack stack) {
        IIcon icon = stack.getItem().getIconFromDamage(stack.getItemDamage());
        if (icon != null)
            return icon.getIconName();
        return null;
    }

    private static ResourceLocation getIconResource(ItemStack stack) {
        String iconName = getIconName(stack);
        if (iconName == null)
            return null;

        String string = "minecraft";

        int colonIndex = iconName.indexOf(58);
        if (colonIndex >= 0) {
            if (colonIndex > 1)
                string = iconName.substring(0, colonIndex);

            iconName = iconName.substring(colonIndex + 1, iconName.length());
        }

        string = string.toLowerCase();
        iconName = "textures/items/" + iconName + ".png";
        return new ResourceLocation(string, iconName);
    }
}
