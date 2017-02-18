package aobd.aobd3.Misc;

import aobd.aobd3.Aobd3;
import net.minecraftforge.common.config.Configuration;

import static aobd.aobd3.Aobd3.configFile;

/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
public class Config {
    static boolean EnableMod = true;
    static boolean DebugMode = true;
    public static void syncConfig() {
        DebugMode = configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL,DebugMode,"Enable Debug Mode. Do Not Use unless Told to do so.");
        if(Aobd3.configFile.hasChanged())
            Aobd3.configFile.save();
    }
}
