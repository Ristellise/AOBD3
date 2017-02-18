package aobd.aobd.Misc;

import aobd.aobd.Aobd;
import aobd.aobd.aobditems.aobditems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * CreativeTabs Nuff said
 */
public class CreativeTab extends CreativeTabs {

    public CreativeTab() {
        super(Aobd.MOD_ID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return aobditems.dust;
    }
}
