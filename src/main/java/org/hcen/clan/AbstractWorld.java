package org.hcen.clan;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.constant.TimeUnit;
import org.hcen.clan.pojo.人;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AbstractWorld {
    @Setter
    private boolean isAllDead = false;
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
            if(isAllDead){
                log.info("所有凡人已死亡，世界终结于 "+ age);
                break;
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
        doGrowInOneTimeUnit(age);
        AbstractWorld.log.trace("当前世界年龄: "+ age);
//        timeSync();
    }

    // children should impl this func
    protected void doGrowInOneTimeUnit(Integer age) {
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
