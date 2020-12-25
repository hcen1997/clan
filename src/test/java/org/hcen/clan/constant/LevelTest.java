package org.hcen.clan.constant;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class LevelTest {

    @Test
    ArrayList<Integer> getMaxAge() {
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
        return integers;
    }

    @Test
    void getMaxAgeMul灵根(){
        ArrayList<Integer> maxAge = getMaxAge();
        for (int i = 0; i < maxAge.size(); i++) {
            System.out.print ("i = " + i);
            System.out.println(" i*maxAge[i] = " + i * maxAge.get(i));
        }
    }
}