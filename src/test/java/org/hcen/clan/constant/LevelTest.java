package org.hcen.clan.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

class LevelTest {

    @Test
    void getMaxAge() {
        HashSet<Integer> age = new HashSet<>();
        for (int i = 0; i < 100_0; i++) {
            Level level = Level.randOne();
            int maxAge = level.getMaxAge();
            age.add(maxAge);
        }
        ArrayList<Integer> integers = new ArrayList<>(age);
        integers.sort(Comparator.naturalOrder());
        String s = integers.toString();
        System.out.println("s = " + s);
    }
}