package aobd.aobd;

import aobd.aobd.Misc.aobdTab;
import aobd.aobd.Proxy.ClientProxy;
import aobd.aobd.libs.Config;
import aobd.aobd.Proxy.CommonProxy;
import aobd.aobd.aobditems.aobditems;
import aobd.aobd.libs.Utils;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
    public void  Preinit(FMLPreInitializationEvent event) {
        Utils.Logger(2,"Config start!");
        configFile = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();
        Utils.Logger(2,"Config Done,ColorHandlers Start!");
        proxy.registerColorsHandlers();
        Utils.Logger(2,"ColorHandlers Done");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        aobditems.init();
    }
}
