package org.hcen.clan.constant;

import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
public class Level {
    // 灵根界限其实是由上级定的
    // 这里甚至可以写 上一级灵根在本级年龄界限的能力值
    private static final long[] 灵根界限 = new long[]{0L,
            500L, 1500, 5000,
            11_000L, 25_000L, 50_000L, // 6级灵根卡脖子
            90_000L, 140_000L, 200_000L};
    private static Level one = new Level();
    private String name;
    private int level;
    private int finalLevel = 10;

    private Level(String name, int level) {
        this.name = name;
        this.level = level;
    }

    private Level(int level) {
        this.name = level + "";
        this.level = level;
    }

    public static Level randOne() {
        int level = ThreadLocalRandom.current().nextInt(0, 10);
        return new Level(level);
    }

    public static Level calLevel(long energy) {
        return new Level(one.doCalLevel(灵根界限, energy));
    }

    private int doCalLevel(long[] map, long energy) {
        for (int i = 0; i < map.length; i++) {
            if (energy <= map[i]) {
                return i;
            }
        }
        // 飞升了哦
//        assert energy > map[map.length - 1];
        return finalLevel;
    }

    public boolean isMax() {
        return level == 10;
    }

    public String getName() {
        return String.valueOf(level);
    }

    public int getMaxAge() {
        if(level==finalLevel){
            return Integer.MAX_VALUE;
        }
//        [100, 258, 652, 1432, 2748, 4750, 7588, 11412, 16372, 22618]
        return  100 + level * 90 + level * level * 43 + level * level * level * 22
                +level * level * level * 3;
    }
}
