package org.hcen.clan.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class 灵根类 {
    private static int[] levelMap = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private String name;
    private int level;
    private int amntPerTimeUnit;


    private 灵根类(int level) {
        this(level + "", level, getAmntByLevel(level));
    }

    public static 灵根类 randOne() {
        int level = ThreadLocalRandom.current().nextInt(0, 10);
        return new 灵根类(level);
    }

    private static int getAmntByLevel(int level) {
        // todo: 更好的设置 // 这个是有0级的，有人修炼一辈子都不会有什么成就
        // 其实没啥可改的 1/8 可是12.5% 9级比8级高出12.5%呢
        return levelMap[level];
    }
}
