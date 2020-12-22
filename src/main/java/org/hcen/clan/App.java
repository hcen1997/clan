package org.hcen.clan;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
        info();
        AbstractWorld theOne = World.TheOne();
        theOne.run();
        end();
    }

    private static void info() {
        log.info("天地初开，宇宙混沌。");
        log.info("道生一，一生二，二生三，三生万物。");
        log.info("二者，阴阳也。阳为空间，阴为时间。");

        log.info("所以世界就这么运行下去了。");
        log.info("=================世界 开始==================");
    }

    private static void end() {
        log.info("=================世界 结束了==================");
        log.info("这个世界到达了他的生命终点");
        log.info("再见了，观察者。");
    }

}
