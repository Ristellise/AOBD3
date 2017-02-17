package aobd.aobd3.Misc;

import com.jwcore.jwcore.JWCore;
import net.minecraftforge.common.config.Configuration;
/**
 * Does Config Stuff For the mod. moved out of main class for less cluster.
 */
public class Config {
    static boolean EnableMod = true;
    static boolean
    public static void syncConfig() {

        NoMoreLavaPocketGen = aobd.configFile.getBoolean("No More Lava Pockets", Configuration.CATEGORY_GENERAL,NoMoreLavaPocketGen,"Makes the Nether Less Dangerous by preventing lava pockets to spawn.");
        Splashinator = JWCore.configFile.getBoolean("Replace Splash Text file",Configuration.CATEGORY_GENERAL,Splashinator,"(Experimental) Replace Splash Text with those custom loaded into via the config file.(TODO)");
        DebugMode = JWCore.configFile.getBoolean("Debug Mode",Configuration.CATEGORY_GENERAL,DebugMode,"Enable Debug Mode With 100% More Spam!");
        if(JWCore.configFile.hasChanged())
            JWCore.configFile.save();
    }
}
