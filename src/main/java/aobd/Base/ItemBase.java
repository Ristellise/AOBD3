package aobd.Base;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    protected String name;
    public ItemBase(final String name) {
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    }
    public void registerItemModel() {

    }
    @Override
    public ItemBase setCreativeTab(final CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
