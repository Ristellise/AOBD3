package aobd.aobd.libs;

import aobd.aobd.Aobd;
import net.minecraftforge.common.config.Configuration;

import static aobd.aobd.Aobd.configFile;

/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
public class Config {
    static boolean EnableMod = true;
    public static boolean DebugMode = true;
    public static void syncConfig() {
        DebugMode = configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL,DebugMode,"Enable Debug Mode. Do Not Use unless Told to do so.");
        if(Aobd.configFile.hasChanged())
            Aobd.configFile.save();
    }
}
