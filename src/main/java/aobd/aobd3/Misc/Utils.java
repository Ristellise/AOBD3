package aobd.aobd3.Misc;

import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Utils {
    private static Logger logger = LogManager.getLogger("JWCore");
    public static void Logger(int Level,Object message){
        if (Level == 0) {
            //Severe Logging
            logger.fatal(message);
        }
        else if (Level == 1) {
            //Warning
            logger.warn(message);
        }
        else if (Level == 2) {
            //info
            logger.info(message);
        }
        else {
            //Not in the range
            FMLLog.bigWarning("'" + message + "' is not in the correct range of 0 to 2! Bug your mod author about it.");
        }
    }
}
