package org.hcen.clan;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.pojo.人;
import org.hcen.clan.service.飞升之路;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class World extends AbstractWorld {
    private final List<人> 人s =人.born(10) ;

    @Autowired
    private 飞升之路 飞升;

    @Override
    public void doGrowInOneTimeUnit(Integer age) {
        var post = new ArrayList<String>();
        var 死亡名单 = new ArrayList<String>();
        for (人 人 : 人s) {
            飞升.updateOne(人);
            if(人.getLevel().isMax()){
                log.info(String.format("飞升者 %s 出现了，今年是 %d",人.getName(),this.age));
            }
            if( 人.getAge()>人.getMaxAge()){
                log.error(String.format("修炼者 %s 死于 %d , 最大年龄 %s",人.getName(),this.age,
                        人.getMaxAge()));
                log.debug("死亡时的能量为"+人.getEnergy());
                死亡名单.add(人.getName());
            }
        }
        死亡名单.forEach(s -> {
            人s.removeIf(人 -> 人.getName().equals(s));
        });
        if(人s.size()==0){
            setAllDead(true);
        }
    }
}
