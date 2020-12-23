package org.hcen.clan;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.pojo.人;
import org.hcen.clan.service.飞升之路;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class World extends AbstractWorld {
    private final List<人> 人s =人.born(10) ;



    @Autowired
    private 飞升之路 飞升;

    @Override
    public void doGrowInOneTimeUnit() {
        for (人 人 : 人s) {
            飞升.updateOne(人);
            if(人.getLevel().isMax()){
                log.info("飞升者 %s 出现了，今年是 %d",人.getName(),this.age);
            }
        }
    }
}
