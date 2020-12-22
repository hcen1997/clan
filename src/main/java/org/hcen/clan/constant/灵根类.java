package org.hcen.clan.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class 灵根类 {
    private String name;
    private int level;
    private int amntPerTimeUnit;
    public static  灵根类 randOne(){
        int level = ThreadLocalRandom.current().nextInt(0, 10);
        return new 灵根类(level +"",level, getAmntByLevel(level));
    }

    private static int getAmntByLevel(int level) {
        // todo: 更好的设置
        return level;
    }
}
