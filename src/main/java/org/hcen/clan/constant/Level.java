package org.hcen.clan.constant;

import java.util.concurrent.ThreadLocalRandom;

public class Level {

    private String name;
    private int level;

    private Level(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public static  Level randOne(){
        int level = ThreadLocalRandom.current().nextInt(0, 10);
        return new Level(level+"",level);
    }
}
