package org.hcen.clan.constant;

public enum TimeUnit {
    年("年", 0, null, null),
    旬("旬", 1, 0, 12 * 3),

    ;


    private String name;
    private Integer level;
    private Integer parent;
    private Integer valToUp;

    TimeUnit(String name, Integer level, Integer parent, Integer valToUp) {
        this.name = name;
        this.level = level;
        this.parent = parent;
        this.valToUp = valToUp;
    }
}
