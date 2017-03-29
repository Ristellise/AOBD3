package aobd;

import aobd.libs.Utils;
import java.util.List;
import net.minecraftforge.fml.common.Loader;

/**
 * Created by joshw on 29/3/2017.
 */
public class Compat {
  List<String> LoadedRegistedMods ;
    public void init() {
      for(CompactCases mods, CompactCases.values())

    }
}

/**"dustTiny", "crushedPurified", "crushed", "dust"
 * RC : Crushed
 * EIO : dust
 * MEK : "clump", "crystal", "shard", "dustDirty", "dust"
 * TC : "cluster", "nugget"
 * TE : "dust"
 * NETHER ORES : "NetherOre"
 * EX NIHILO : "orePowdered", "oreBroken", "oreNetherBroken", "oreCrushed", "oreSand", "oreDust", "oreGravel", "oreNetherGravel"
 */
enum CompactCases {
  IC2,
  RAILCRAFT,
  ENDERIO,
  MEKANISM,
  THAUMCRAFT,
  THERMAL_EXPANSION,
  NETHER_ORES,
  APPLIED_ENERGISTICS,
  TINKERS_CONSTRUCT,
  IMMERSIVE_ENGINEERING,
  EX_NIHILO
}
