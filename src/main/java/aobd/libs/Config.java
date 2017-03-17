package aobd.libs;

import aobd.Aobd;
import net.minecraftforge.common.config.Configuration;

import static aobd.Aobd.configFile;

/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
public class Config {
    static boolean EnableMod = true;
    public static boolean DebugMode = true;
    public static boolean EnableWitty = false;
    public static void syncConfig() {
        DebugMode = configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL,DebugMode,"Enable Debug Mode. Do Not Use unless Told to do so.");
        EnableWitty = configFile.getBoolean("Enable Witty",Configuration.CATEGORY_GENERAL,EnableWitty,"Adds Small Witty messages on startup.. Cuz jared said 'If you make your mod log that in the console. I will make a mod that removes ALL output from your mod.'");
        if(Aobd.configFile.hasChanged())
            Aobd.configFile.save();
    }
}
