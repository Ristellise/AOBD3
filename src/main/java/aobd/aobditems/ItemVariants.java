package aobd.aobditems;

import aobd.Aobd;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Item Variants
 */
public class ItemVariants extends Item {
  public ItemVariants() {
    this.setMaxDamage(0);
    this.setMaxStackSize(64);
    this.setHasSubtypes(true);
    this.setCreativeTab(Aobd.aobdTab);
  }
  @Override
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
    for()
  }
  @Override
  public EnumAction getItemUseAction(ItemStack stack)
  {
    return EnumAction.NONE;
  }
  @Override
  public int getMetadata(int damage) {
    return damage;
  }
  public String getUnlocalizedName(ItemStack stack)
  {
    int metadata = stack.getMetadata();

  }
}
enum DynamicEnums {
  DUSTS()
}
