package org.hcen.clan.service;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.pojo.人;
import org.springframework.stereotype.Service;

@Slf4j
@Service("飞升")
public class 飞升之路 {

    public void updateOne(人 ren) {
        根据灵根计算一旬增加多少(ren);
        人年龄增加(ren);
        log.trace(String.format("修行者‘%s’勤奋修炼，能量增加为%d, 目前等级为%s",
                ren.getName(), ren.getEnergy(), ren.getLevel().getName()));
    }

    private void 人年龄增加(人 ren) {
        ren.setAge(ren.getAge()+1);
    }

    private void 根据灵根计算一旬增加多少(人 ren) {
        ren.setEnergy(ren.getEnergy()+ren.get灵根().getAmntPerTimeUnit());
    }
}
