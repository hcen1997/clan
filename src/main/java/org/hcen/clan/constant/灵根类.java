package org.hcen.clan.constant;

import java.util.concurrent.ThreadLocalRandom;

public class 灵根类 {
    private String name;
    private int level;
    private 灵根类(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public static  灵根类 randOne(){
        int level = ThreadLocalRandom.current().nextInt(0, 10);
        return new 灵根类(level+"",level);
    }
}
