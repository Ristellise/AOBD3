package aobd.libs;

import net.minecraftforge.common.config.Configuration;

import static aobd.Aobd.configFile;

/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
public class Config {
    public static boolean DebugMode = true;
    public static void syncConfig() {
        DebugMode = configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL, DebugMode,"Enable Debug Mode. Do Not Use unless Told to do so.");
        if(configFile.hasChanged())
            configFile.save();
    }
}
