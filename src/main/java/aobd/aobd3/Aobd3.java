package aobd.aobd3;

import aobd.aobd3.Misc.Config;
import aobd.aobd3.aobditems.aobditems;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Aobd3.MOD_ID,
        name = Aobd3.MOD_NAME,
        version = Aobd3.VERSION
)
public class Aobd3 {
    @SidedProxy(
            serverSide = "com.aobd.aobd.Proxy.CommonProxy",
            clientSide = "com.aobd.aobd.Proxy.ClientProxy"
    )
    public static final String MOD_ID = "aobd3";
    public static final String MOD_NAME = "Another One Bites the Dust Redux";
    public static final String VERSION = "1.0";
    @EventHandler
    public void  Preinit(FMLPreInitializationEvent event) {
        Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
        Config.syncConfig();
        aobditems.init();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
