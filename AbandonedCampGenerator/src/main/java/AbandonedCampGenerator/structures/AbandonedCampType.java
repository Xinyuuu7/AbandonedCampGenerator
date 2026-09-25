package AbandonedCampGenerator.structures;

import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mcbiome.biome.Biomes;

public enum AbandonedCampType {
    BAMBOO_JUNGLE,
    BIRCH_FOREST,
    CHERRY_GROVE,
    DAPPLED_FOREST,
    FLOWER_FOREST,
    FOREST,
    MEADOW,
    OLD_GROWTH_BIRCH_FOREST,
    OLD_GROWTH_PINE_TAIGA,
    OLD_GROWTH_SPRUCE_TAIGA,
    PALE_GARDEN,
    SAVANNA,
    SNOWY_TAIGA,
    SPARSE_JUNGLE,
    SWAMP,
    TAIGA,
    WINDSWEPT_FOREST,
    WOODED_BADLANDS;

    public static AbandonedCampType getType(Biome biome) {
        if(Biomes.BAMBOO_JUNGLE.equals(biome)) {
            return BAMBOO_JUNGLE;
        }
        if(Biomes.BIRCH_FOREST.equals(biome)) {
            return BIRCH_FOREST;
        }
        if(Biomes.CHERRY_GROVE.equals(biome)) {
            return CHERRY_GROVE;
        }
        if(Biomes.DAPPLED_FOREST.equals(biome)) {
            return DAPPLED_FOREST;
        }
        if(Biomes.FLOWER_FOREST.equals(biome)) {
            return FLOWER_FOREST;
        }
        if(Biomes.FOREST.equals(biome)) {
            return FOREST;
        }
        if(Biomes.MEADOW.equals(biome)) {
            return MEADOW;
        }
        if(Biomes.OLD_GROWTH_BIRCH_FOREST.equals(biome)) {
            return OLD_GROWTH_BIRCH_FOREST;
        }
        if(Biomes.OLD_GROWTH_PINE_TAIGA.equals(biome)) {
            return OLD_GROWTH_PINE_TAIGA;
        }
        if(Biomes.OLD_GROWTH_SPRUCE_TAIGA.equals(biome)) {
            return OLD_GROWTH_SPRUCE_TAIGA;
        }
        if(Biomes.PALE_GARDEN.equals(biome)) {
            return PALE_GARDEN;
        }
        if(Biomes.SAVANNA.equals(biome)) {
            return SAVANNA;
        }
        if(Biomes.SNOWY_TAIGA.equals(biome)) {
            return SNOWY_TAIGA;
        }
        if(Biomes.SPARSE_JUNGLE.equals(biome)) {
            return SPARSE_JUNGLE;
        }
        if(Biomes.SWAMP.equals(biome)) {
            return SWAMP;
        }
        if(Biomes.TAIGA.equals(biome)) {
            return TAIGA;
        }
        if(Biomes.WINDSWEPT_FOREST.equals(biome)) {
            return WINDSWEPT_FOREST;
        }
        if(Biomes.WOODED_BADLANDS.equals(biome)) {
            return WOODED_BADLANDS;
        }
        return null;
    }
}