package api.skies;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.fml.common.Mod;

@Mod(SkiesLib.MODID)
public class SkiesLib {
    public static final String MODID = "skieslib";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SkiesLib() {
        LOGGER.info("[SkiesLib] Loaded");
    }
}
