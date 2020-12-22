package org.hcen.clan;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.constant.TimeUnit;

@Slf4j
public class AbstractWorld {
    private static AbstractWorld world;
    private static Integer MAX_AGE = Integer.MAX_VALUE;
    private static TimeUnit TIME_UNIT = TimeUnit.年;
    // 现实世界纳秒对比模拟世界年
    private static Long TIME_TRANS = 2_000_000_000L;
    protected Integer age;

    protected AbstractWorld() {
        age = 0;
    }

    public static AbstractWorld TheOne() {
        if (AbstractWorld.world == null) {
            AbstractWorld.world = new AbstractWorld();
        }
        return AbstractWorld.world;
    }

    public  void  run() {
        debugInfo();
        while (age < AbstractWorld.MAX_AGE) {
            grow();
        }
    }

    private void debugInfo() {
        AbstractWorld.log.debug("模拟世界与现实世界时间比例: " + calTimeRate());
    }

    private String calTimeRate() {
        long convert = java.util.concurrent.TimeUnit.NANOSECONDS.convert(365L, java.util.concurrent.TimeUnit.DAYS);
        long rate = convert / AbstractWorld.TIME_TRANS;
        return rate + ":1";
    }

    private void grow() {
        age = age + 1;
        // grow all objects withing the world
        doGrowInOneTimeUnit();
        AbstractWorld.log.trace("当前世界年龄: "+ age);
        timeSync();
    }

    // children should impl this func
    protected void doGrowInOneTimeUnit() {
        // stub~
    }

    private void timeSync() {
        try {
            java.util.concurrent.TimeUnit.NANOSECONDS.sleep(AbstractWorld.TIME_TRANS);
        } catch (InterruptedException e) {
            AbstractWorld.log.error("严重警报！！！检测到时间入侵者");
        }
    }
}
