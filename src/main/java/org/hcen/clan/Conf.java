package org.hcen.clan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class Conf {
    @Bean
    public DataSource mq(){
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setUrl("ffff");
        return simpleDriverDataSource;
    }


}
