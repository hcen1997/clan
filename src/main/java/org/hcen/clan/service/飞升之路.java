package org.hcen.clan.service;

import lombok.extern.slf4j.Slf4j;
import org.hcen.clan.pojo.人;
import org.springframework.stereotype.Service;

@Slf4j
@Service("飞升")
public class 飞升之路 {

    public void updateOne(人 人) {
        // 根据灵根计算一旬增加多少
        人.updateBy灵根();
      log.trace("修行者‘%s’勤奋修炼，能量增加为%l, 目前等级为%s",人.getName(),人.getEnergy(),人.getLevel());
    }
}
