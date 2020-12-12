package org.hcen.clan;

import org.hcen.clan.constant.TimeUnit;

public class World {
    private static World world;
    public static World TheOne() {
        if (world == null) {
            world = new World();
        }
        return world;
    }

    private static Integer MAX_AGE = Integer.MAX_VALUE;
    private static TimeUnit TIME_UNIT = TimeUnit.年;

    private  Integer age;
    private World() {
        age = 0;

    }

    public void run(){
        while (age<MAX_AGE){
            grow();
        }
    }

    private void grow() {
        age= age+1;
    }

    //

}
