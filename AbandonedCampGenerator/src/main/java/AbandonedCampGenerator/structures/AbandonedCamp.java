package AbandonedCampGenerator.structures;

import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.state.Dimension;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mccore.version.VersionMap;
import com.seedfinding.mcfeature.structure.UniformStructure;

public class AbandonedCamp extends UniformStructure<AbandonedCamp> {
    // version here should be 26_3
    public static final VersionMap<Config> CONFIGS = new VersionMap<Config>()
            .add(MCVersion.v1_21, new Config(37, 8, 91231127));

    public AbandonedCamp(MCVersion version) {
        this(CONFIGS.getAsOf(version), version);
    }

    public AbandonedCamp(Config config, MCVersion version) {
        super(config, version);
    }

    public static String name() {
        return "ancient_city";
    }

    @Override
    public boolean canStart(Data<AbandonedCamp> data, long structureSeed, ChunkRand rand) {
        return super.canStart(data, structureSeed, rand);
    }

    @Override
    public Dimension getValidDimension() {
        return Dimension.OVERWORLD;
    }

    @Override
    public boolean isValidBiome(Biome biome) {
        return false;
    }
}