package org.hcen.clan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class Conf {
    @Bean
    public DataSource mq() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setUrl("ffff");
        return simpleDriverDataSource;
    }

    @Bean
        public ThreadPoolExecutor 观察者们() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 200,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        return threadPoolExecutor;
    }

}
