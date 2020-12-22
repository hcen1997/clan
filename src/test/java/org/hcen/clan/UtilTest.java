package org.hcen.clan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void randName() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Util.randName() = " + Util.randName());
        }
    }
}