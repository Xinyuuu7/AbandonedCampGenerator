package AbandonedCampGenerator;

import AbandonedCampGenerator.structures.AbandonedCampPools;
import AbandonedCampGenerator.structures.AbandonedCampStructureSize;
import AbandonedCampGenerator.structures.AbandonedCampType;
import AbandonedCampGenerator.structures.PoolType;
import AbandonedCampGenerator.util.VoxelShape;
import com.seedfinding.mcbiome.biome.Biome;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.block.BlockRotation;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;

import java.util.*;

public class AbandonedCampGenerator {
    private List<Piece> pieces;
    private static final int MAX_DIST = 80; // max distance from start piece anchor
    private AbandonedCampType type;
    private long worldSeed;

    public AbandonedCampGenerator() {}

    public boolean generate(long worldSeed, CPos pos) {
        this.worldSeed = worldSeed;
        return generate(worldSeed, pos.getX(), pos.getZ(), new ChunkRand());
    }

    public boolean generate(long worldSeed, int chunkX, int chunkZ, ChunkRand rand) {
        this.pieces = new ArrayList<>();

        rand.setCarverSeed(worldSeed, chunkX, chunkZ, MCVersion.v1_20);
        /*
        random for rotation and y here?
         */

        // choose random starting template by checking the biome
        Biome biome = biomeSource.getBiomeSource().getBiomeForNoiseGen((chunkX << 2) + 2, 0, (chunkZ << 2) + 2);
        this.type = AbandonedCampType.getType(biome);
        JigSawPool jigSawPool = TYPE_TO_START.get(type);
        String template = rand.getRandom(jigSawPool.getTemplates());
        BPos size = AbandonedCampStructureSize.STRUCTURE_SIZE.get(template);
        return true;
    }

    static public class Piece {
        String name;
        public BPos pos;
        public BlockBox box;
        public BlockRotation rotation;
        int boundsTop;
        private VoxelShape voxelShape;
        int depth;

        public String getName() {
            return this.name;
        }

        Piece(String name, BPos pos, BlockBox box, BlockRotation rotation, int depth) {
            this.name = name;
            this.pos = pos;
            this.box = box;
            this.rotation = rotation;
            this.voxelShape = new VoxelShape(box);
            this.depth = depth;
        }

        public void move(int x, int y, int z) {
            box.move(x, y, z);
            pos = pos.add(x, y, z);
        }

        public void setBoundsTop(int boundsTop) {
            this.boundsTop = boundsTop;
        }

        public void setVoxelShape(VoxelShape mutableObject1) {
            this.voxelShape = mutableObject1;
        }

        public BPos getTransformedPos(BPos targetPos, BlockRotation rotationIn) {
            int i = targetPos.getX();
            int j = targetPos.getY();
            int k = targetPos.getZ();
            return switch (rotationIn) {
                case COUNTERCLOCKWISE_90 -> new BPos(k, j, -i);
                case CLOCKWISE_90 -> new BPos(-k, j, +i);
                case CLOCKWISE_180 -> new BPos(-i, j, -k);
                default -> targetPos;
            };
        }
    }

    public static class JigSawPool {
        private final LinkedList<String> templates = new LinkedList<>();

        JigSawPool(List<Pair<String, Integer>> templates) {
            for(Pair<String, Integer> template : templates) {
                for(int i = 0; i < template.getSecond(); i++) {
                    this.templates.addLast(template.getFirst());
                }
            }
        }

        public LinkedList<String> getTemplates() {
            return templates;
        }
    }

    public static final Map<AbandonedCampType, JigSawPool> TYPE_TO_START = new HashMap<>() {
        {
            put(AbandonedCampType.BAMBOO_JUNGLE, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_BAMBOO_JUNGLE)));
            put(AbandonedCampType.BIRCH_FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_BIRCH_FOREST)));
            put(AbandonedCampType.CHERRY_GROVE, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_CHERRY_GROVE)));
            put(AbandonedCampType.DAPPLED_FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_DAPPLED_FOREST)));
            put(AbandonedCampType.FLOWER_FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_FLOWER_FOREST)));
            put(AbandonedCampType.FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_FOREST)));
            put(AbandonedCampType.MEADOW, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_MEADOW)));
            put(AbandonedCampType.OLD_GROWTH_BIRCH_FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_OLD_GROWTH_BIRCH_FOREST)));
            put(AbandonedCampType.OLD_GROWTH_PINE_TAIGA, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_OLD_GROWTH_PINE_TAIGA)));
            put(AbandonedCampType.OLD_GROWTH_SPRUCE_TAIGA, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_OLD_GROWTH_SPRUCE_TAIGA)));
            put(AbandonedCampType.PALE_GARDEN, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_PALE_GARDEN)));
            put(AbandonedCampType.SAVANNA, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_SAVANNA)));
            put(AbandonedCampType.SNOWY_TAIGA, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_SNOWY_TAIGA)));
            put(AbandonedCampType.SPARSE_JUNGLE, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_SPARSE_JUNGLE)));
            put(AbandonedCampType.SWAMP, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_SWAMP)));
            put(AbandonedCampType.TAIGA, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_TAIGA)));
            put(AbandonedCampType.WINDSWEPT_FOREST, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_WINDSWEPT_FOREST)));
            put(AbandonedCampType.WOODED_BADLANDS, new JigSawPool(AbandonedCampPools.ABANDONEDCAMP_POOLS.get(PoolType.TENT_WOODED_BADLANDS)));
        }};
}