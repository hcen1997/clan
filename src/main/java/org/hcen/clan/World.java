package org.hcen.clan;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.constant.TimeUnit;

import java.util.logging.Level;

@Slf4j
public class World {
    private static World world;

    public static World TheOne() {
        if (world == null) {
            world = new World();
        }
        return world;
    }

    private static Integer MAX_AGE = Integer.MAX_VALUE;
    private static TimeUnit TIME_UNIT = TimeUnit.年;
    // 现实世界纳秒对比模拟世界年
    private static Long TIME_TRANS = 2_000_000_000L;

    private Integer age;

    private World() {
        age = 0;

    }

    public void run() {
        debugInfo();
        while (age < MAX_AGE) {
            grow();
        }
    }

    private void debugInfo() {
        log.debug("模拟世界与现实世界时间比例: " + calTimeRate());
    }

    private String calTimeRate() {
        long convert = java.util.concurrent.TimeUnit.NANOSECONDS.convert(365L, java.util.concurrent.TimeUnit.DAYS);
        long rate = convert / TIME_TRANS;
        return rate + ":1";
    }

    private void grow() {
        age = age + 1;
        // grow all objects withing the world

        log.trace("当前世界年龄: "+ age);
        timeSync();
    }

    private void timeSync() {
        try {
            java.util.concurrent.TimeUnit.NANOSECONDS.sleep(TIME_TRANS);
        } catch (InterruptedException e) {
            log.error("严重警报！！！检测到时间入侵者");
        }
    }

    //

}
