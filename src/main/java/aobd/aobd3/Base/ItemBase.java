package aobd.aobd3.Base;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by joshw on 11/2/2017.
 */
public class ItemBase extends Item {
    protected String name;
    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }
    public void registerItemModel() {

    }
    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
