package AbandonedCampGenerator.jigsaws;

import AbandonedCampGenerator.structures.PoolType;
import com.seedfinding.mccore.util.block.BlockDirection;
import com.seedfinding.mccore.util.pos.BPos;

public class JigsawBlock {
    public PoolType poolType;
    public String name;
    public String targetName;
    public BlockDirection direction;
    public BPos relativePos;

    public JigsawBlock(PoolType poolType, String name, String targetName, BlockDirection direction, BPos relativePos) {
        this.poolType = poolType;
        this.name = name;
        this.targetName = targetName;
        this.direction = direction;
        this.relativePos = relativePos;
    }
}