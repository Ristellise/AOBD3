package aobd.Ores;
import java.util.ArrayList;
import java.util.List;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Searches For ores in oredictionary
 */
public class OreDict {
    private static List<String> OreNames = new ArrayList<String>();
    public static void init() {
        OreNames.add("ore");
        filterOreDict();
    }
    public static void filterOreDict() {

    }
}
