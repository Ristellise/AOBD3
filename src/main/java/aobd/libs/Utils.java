package aobd.libs;

import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Utils {
    private static final Logger logger = LogManager.getLogger("aobd");
    public static void Logger(int Level, Object message){
        if (Level == 0) {
            //Severe Logging
          Utils.logger.fatal(message);
        }
        else if (Level == 1) {
            //Warning
          Utils.logger.warn(message);
        }
        else if (Level == 2) {
            //info
          Utils.logger.info(message);
        }
        else {
            //Not in the range
            FMLLog.bigWarning("'" + message + "' is not in the correct range of 0 to 2! Bug your mod author about it.");
        }
    }
}
