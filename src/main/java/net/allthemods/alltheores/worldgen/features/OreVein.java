package net.allthemods.alltheores.worldgen.features;

import com.mojang.serialization.Codec;
import net.allthemods.alltheores.infos.Configuration;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.server.permission.context.WorldContext;

import java.util.Random;

public class OreVein extends Feature<NoneFeatureConfiguration> {
private Block oreType;
private Block deepSlate_oreType;
private BlockPos genLocation;
private Direction[] directions = { Direction.UP,Direction.DOWN,Direction.NORTH,Direction.EAST,Direction.SOUTH,Direction.WEST};

    public OreVein(Codec<NoneFeatureConfiguration> p_i231953_1_, Block oretype, Block deepSlate_oretype) {
        super(p_i231953_1_);
        this.oreType = oretype;
        this.deepSlate_oreType = deepSlate_oretype;

    }

    private BlockPos getPreviousLocation() {
        return this.genLocation;
    }



    @Override
    public Codec<ConfiguredFeature<NoneFeatureConfiguration, Feature<NoneFeatureConfiguration>>> configuredCodec() {
        return super.configuredCodec();
    }

    @Override
    public ConfiguredFeature<NoneFeatureConfiguration, ?> configured(NoneFeatureConfiguration p_225566_1_) {
        return super.configured(p_225566_1_);
    }




    @Override
    public boolean place(FeaturePlaceContext config) {
        BlockPos pos = config.origin();
        Random rand = config.random();
        WorldGenLevel world = config.level();
        BlockPos prev;
        if(this.getPreviousLocation() != null) { prev = this.getPreviousLocation();}
        else { prev = new BlockPos(0,65,0); }

        int minY = -64,maxY = -64,veinSize = -64,veinCount = -64,curY = -64, curX,curZ;
        curY = pos.getY();
        int direction = rand.nextInt(5);

        switch(this.oreType.getRegistryName().toString()) {
            case "alltheores:aluminum_ore":
                minY = Configuration.COMMON.aluminum_MinY.get();
                maxY = Configuration.COMMON.aluminum_MaxY.get();
                veinSize = Configuration.COMMON.aluminum_SpawnSize.get();
                veinCount = Configuration.COMMON.aluminum_VeinCount.get();
            case "alltheores:lead_ore":
                minY = Configuration.COMMON.lead_MinY.get();
                maxY = Configuration.COMMON.lead_MaxY.get();
                veinSize = Configuration.COMMON.lead_SpawnSize.get();
                veinCount = Configuration.COMMON.lead_VeinCount.get();
            case "alltheores:nickel_ore":
                minY = Configuration.COMMON.nickel_MinY.get();
                maxY = Configuration.COMMON.nickel_MaxY.get();
                veinSize = Configuration.COMMON.nickel_SpawnSize.get();
                veinCount = Configuration.COMMON.nickel_VeinCount.get();
            case "alltheores:osmium_ore":
                minY = Configuration.COMMON.osmium_MinY.get();
                maxY = Configuration.COMMON.osmium_MaxY.get();
                veinSize = Configuration.COMMON.osmium_SpawnSize.get();
                veinCount = Configuration.COMMON.osmium_VeinCount.get();
            case "alltheores:platinum_ore":
                minY = Configuration.COMMON.platinum_MinY.get();
                maxY = Configuration.COMMON.platinum_MaxY.get();
                veinSize = Configuration.COMMON.platinum_SpawnSize.get();
                veinCount = Configuration.COMMON.platinum_VeinCount.get();
            case "alltheores:silver_ore":
                minY = Configuration.COMMON.silver_MinY.get();
                maxY = Configuration.COMMON.silver_MaxY.get();
                veinSize = Configuration.COMMON.silver_SpawnSize.get();
                veinCount = Configuration.COMMON.silver_VeinCount.get();
            case "alltheores:tin_ore":
                minY = Configuration.COMMON.tin_MinY.get();
                maxY = Configuration.COMMON.tin_MaxY.get();
                veinSize = Configuration.COMMON.tin_SpawnSize.get();
                veinCount = Configuration.COMMON.tin_VeinCount.get();
            case "alltheores:uranium_ore":
                minY = Configuration.COMMON.uranium_MinY.get();
                maxY = Configuration.COMMON.uranium_MaxY.get();
                veinSize = Configuration.COMMON.uranium_SpawnSize.get();
                veinCount = Configuration.COMMON.uranium_VeinCount.get();
            case "alltheores:zinc_ore":
                minY = Configuration.COMMON.zinc_MinY.get();
                maxY = Configuration.COMMON.zinc_MaxY.get();
                veinSize = Configuration.COMMON.zinc_SpawnSize.get();
                veinCount = Configuration.COMMON.zinc_VeinCount.get();
        }
        boolean negX = rand.nextBoolean();
        boolean negZ = rand.nextBoolean();
        int offsetX=rand.nextInt(12)+4;
        int offsetZ=rand.nextInt(12)+4;
        if(negX){ offsetX = offsetX *-1;}
        if(negZ){ offsetZ = offsetZ *-1;}
        int targetY = rand.nextInt(maxY - minY) + minY;
        pos = new BlockPos(pos.getX() + offsetX, targetY, pos.getZ() + offsetZ);
        BlockState state = world.getBlockState(pos);
        int processed = 0;
            if ((veinSize <= 0) || (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock()))) {
                return false;
            }
            int step = (veinSize - 1) / 3;
            world.setBlock(pos, pos.getY() > 0 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2);
            processed++;
            int new_direction = 0;
            for (int i = 0; i <= step; i++) {
                //direction { Direction.UP,Direction.DOWN,Direction.NORTH,Direction.EAST,Direction.SOUTH,Direction.WEST};
            if (processed == veinSize) {
                break;
            }
            if(rand.nextBoolean()) { processed = processed + allBlocks(this,world, pos); }
            switch (direction) {
                case 0:
                    for (int up = 1; up <= 3; up++) {
                        state = world.getBlockState(pos.above());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.above(), pos.above().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.above();

                    }
                    new_direction = rand.nextInt(5);

                    if (new_direction == direction) {
                        direction = direction + 2;
                        break;
                    } else { direction = new_direction; }
                case 1:
                    for (int down = 1; down <= 3; down++) {
                        state = world.getBlockState(pos.below());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.below(),pos.below().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.below();
                    }
                    new_direction = rand.nextInt(5);
                    if (new_direction == direction) {
                        direction = direction + 2;
                        break;
                    }else { direction = new_direction; }
                case 2:
                    for (int north = 1; north <= 3; north++) {
                        state = world.getBlockState(pos.north());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.north(), pos.north().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.north();
                    }
                    new_direction = rand.nextInt(5);
                    if (new_direction == direction) {
                        direction = direction + 1;
                        break;
                    } else { direction = new_direction; }
                case 3:
                    for (int east = 1; east <= 3; east++) {
                        state = world.getBlockState(pos.east());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.east(), pos.east().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.east();
                    }
                    new_direction = rand.nextInt(5);
                    if (new_direction == direction) {
                        direction = direction + 1;
                        break;
                    } else { direction = new_direction; }
                case 4:
                    for (int south = 1; south <= 3; south++) {
                        state = world.getBlockState(pos.south());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.south(), pos.south().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.south();
                    }
                    new_direction = rand.nextInt(5);
                    if (new_direction == direction) {
                        direction = direction + 1;
                        break;
                    } else { direction = new_direction; }
                case 5:
                    for (int west = 1; west <= 3; west++) {
                        state = world.getBlockState(pos.west());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            break;
                        }
                        world.setBlock(pos.west(), pos.west().getY() > 16 ? this.oreType.defaultBlockState() : this.deepSlate_oreType.defaultBlockState() , 2, 512);
                        processed++;
                        if (processed == veinSize) {
                            break;
                        }
                        pos = pos.west();
                    }
                    new_direction = rand.nextInt(5);
                    if (new_direction == direction) {
                        direction = direction - 3;
                        break;
                    } else { direction = new_direction; }
                }
            }

        if( (processed>0) ) {
            this.genLocation = pos;
            return true; }
        return false;
    }

    private int allBlocks(OreVein oreVein, WorldGenLevel world, BlockPos pos) {
        int x = 0;

        BlockState state = world.getBlockState(pos.below());
        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
            return x;
        } else {
            world.setBlock(pos.below(), pos.below().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
            x++;
            state = world.getBlockState(pos.above());
            if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                return x;
            } else {
                world.setBlock(pos.above(), pos.above().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
                x++;
                state = world.getBlockState(pos.east());
                if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                    return x;
                } else {
                    world.setBlock(pos.east(), pos.east().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
                    x++;
                    state = world.getBlockState(pos.west());
                    if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                        return x;
                    } else {
                        world.setBlock(pos.west(), pos.west().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
                        x++;
                        state = world.getBlockState(pos.north());
                        if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                            return x;
                        } else {
                            world.setBlock(pos.north(), pos.north().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
                            x++;
                            state = world.getBlockState(pos.south());
                            if (Reference.WORLDGEN_BLACKLIST.contains(state.getBlock())) {
                                return x;
                            } else {
                                world.setBlock(pos.south(), pos.south().getY() > 16 ? oreVein.oreType.defaultBlockState() : oreVein.deepSlate_oreType.defaultBlockState(), 2, 512);
                                x++;
                            }
                        }
                    }
                }
            }
        }

        return x;

    }

}
