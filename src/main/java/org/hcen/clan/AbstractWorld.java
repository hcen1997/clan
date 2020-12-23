package org.hcen.clan;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.constant.TimeUnit;

@Slf4j
public class AbstractWorld {
    private static Integer MAX_AGE = 100_0000;
    private static TimeUnit TIME_UNIT = TimeUnit.年;
    // 现实世界纳秒对比模拟世界年 // 1秒1年
    private static Long TIME_STANDER = 2_000_000_000L;
    private static long SPEED = 5000L;
    protected Integer age;

    protected AbstractWorld() {
        age = 0;
    }

    public  void  run() {
        debugInfo();
        while (age < AbstractWorld.MAX_AGE) {
            grow();
            if(age%1000==0){
                log.info("一千年过去了 当前世界年龄: "+ age);
            }
        }
    }

    private void debugInfo() {
        AbstractWorld.log.debug("模拟世界与现实世界时间比例: " + calTimeRate());
    }

    private String calTimeRate() {
        long convert = java.util.concurrent.TimeUnit.NANOSECONDS.convert(365L, java.util.concurrent.TimeUnit.DAYS);
        long rate = convert / AbstractWorld.TIME_STANDER;
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
            Long timeStander = AbstractWorld.TIME_STANDER;
            timeStander = timeStander/SPEED;
            java.util.concurrent.TimeUnit.NANOSECONDS.sleep(timeStander);
        } catch (InterruptedException e) {
            AbstractWorld.log.error("严重警报！！！检测到时间入侵者");
        }
    }
}
