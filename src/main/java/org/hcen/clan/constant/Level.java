package org.hcen.clan.constant;

import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
public class Level {
    private static Level one = new Level();
    public static final long[] MAP = new long[]{0L,
            100L, 500L, 1000L,
            2000L, 5000L, 10_000L,
            50_000L, 200_000L, 10_000_000L};

    private String name;
    private int level;

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
        return new Level(one.doCalLevel(MAP, energy));
    }

    private int doCalLevel(long[] map, long energy) {
        for (int i = 0; i < map.length; i++) {
            if (energy < map[i]) {
                return i;
            }
        }
        // 飞升了哦
        return 10;
    }

    public boolean isMax() {
        return level == 10;
    }

    public String getName(){
        return String.valueOf(level);
    }

    public int getMaxAge() {
        return level*100 + level*level*60 + level*level*level*20 + 100;
    }
}
