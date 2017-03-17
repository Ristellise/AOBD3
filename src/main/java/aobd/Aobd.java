package aobd;

import aobd.ModSearch.IMCSearch;
import aobd.Misc.aobdTab;
import aobd.libs.Config;
import aobd.Proxy.CommonProxy;
import aobd.aobditems.aobditems;
import aobd.libs.Utils;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;

@Mod(
        modid = Aobd.MOD_ID,
        name = Aobd.MOD_NAME,
        version = Aobd.VERSION,
        dependencies = "required-after:Forge@[10.13.4.1558,);after:*"
)
public class Aobd {
    @SidedProxy(
            serverSide = "aobd.Proxy.CommonProxy",
            clientSide = "aobd.Proxy.ClientProxy"
    )
    public static CommonProxy proxy;
    public static final aobdTab aobdTab = new aobdTab();
    public static Configuration configFile;
    public static final String MOD_ID = "aobd";
    public static final String MOD_NAME = "Another One Bites the Dust";
    public static final String VERSION = "3.0";
    @EventHandler
    public void Preinit(final FMLPreInitializationEvent event) {
        configFile = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();
        Utils.Logger(2, "Sync Config Done.");
        aobditems.init();
        proxy.registerColorsHandlers();
        Utils.Logger(2,"PreInit Finished!");
    }
    @EventHandler
    public void init(final FMLInitializationEvent event) {

        if (Config.DebugMode) {
            Utils.Logger(2, "OreNames: " + Arrays.toString(OreDictionary.getOreNames()));
        }
    }
    @EventHandler
    public void Postinit(final FMLPostInitializationEvent event) {
        Utils.Logger(2,"Searching For ModSearch Mods...");
        IMCSearch.init();
    }
}
