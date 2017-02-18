package aobd.aobd.Misc;

import aobd.aobd.Aobd;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.SidedProxy;

import static aobd.aobd.Aobd.configFile;

/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
@SidedProxy(serverSide = S)
public class Config {
    static boolean EnableMod = true;
    public static boolean DebugMode = true;
    public static void syncConfig() {
        DebugMode = configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL,DebugMode,"Enable Debug Mode. Do Not Use unless Told to do so.");
        if(Aobd.configFile.hasChanged())
            Aobd.configFile.save();
    }
}
