package org.hcen.clan.pojo;

import org.junit.jupiter.api.Test;

import java.util.List;


public class 人Test {

    @Test
    public void getLevel() {
        List<人> born = 人.born(1);
        人 one = born.get(0);
        for (int i = 0; i < 1000_0000; i++) {
            one.updateBy灵根();
        }
        boolean max = one.getLevel().isMax();
        assert max;
    }
}