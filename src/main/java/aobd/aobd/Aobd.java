package aobd.aobd;

import aobd.aobd.Misc.WittyText;
import aobd.aobd.ModSearch.IMCSearch;
import aobd.aobd.Misc.aobdTab;
import aobd.aobd.libs.Config;
import aobd.aobd.Proxy.CommonProxy;
import aobd.aobd.aobditems.aobditems;
import aobd.aobd.libs.Utils;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Random;

@Mod(
        modid = Aobd.MOD_ID,
        name = Aobd.MOD_NAME,
        version = Aobd.VERSION,
        dependencies = "required-after:Forge@[10.13.4.1558,);after:*"
)
public class Aobd {
    @SidedProxy(
            serverSide = "aobd.aobd.Proxy.CommonProxy",
            clientSide = "aobd.aobd.Proxy.ClientProxy"
    )
    public static CommonProxy proxy;
    public static final aobdTab aobdTab = new aobdTab();
    public static Configuration configFile;
    public static final String MOD_ID = "aobd";
    public static final String MOD_NAME = "Another One Bites the Dust";
    public static final String VERSION = "3.0";
    @EventHandler
    public void Preinit(FMLPreInitializationEvent event) {
        configFile = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();
        if (Config.EnableWitty) {
            WittyText.ILikeToPopulateThings();
            Random r = new Random();
            Utils.Logger(2, WittyText.Wittytext[r.nextInt(WittyText.Wittytext.length)]);
        }
        proxy.registerColorsHandlers();
        Utils.Logger(2,"PreInit Finished!");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        aobditems.init();
    }
    @EventHandler
    public void Postinit(FMLPostInitializationEvent event) {
        Utils.Logger(2,"Searching For ModSearch Mods...");
        IMCSearch.init();
    }
}
