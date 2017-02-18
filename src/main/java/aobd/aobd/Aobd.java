package aobd.aobd;

import aobd.aobd.Misc.Config;
import aobd.aobd.aobditems.aobditems;
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

    public static Configuration configFile;
    public static final String MOD_ID = "aobd";
    public static final String MOD_NAME = "Another One Bites the Dust";
    public static final String VERSION = "3.0";
    @EventHandler
    public void  Preinit(FMLPreInitializationEvent event) {

        configFile = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();
        aobditems.init();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
