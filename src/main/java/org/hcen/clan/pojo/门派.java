package org.hcen.clan.pojo;


import lombok.Data;

import java.util.List;

/**
 * 这是世界的基础 门派
 * 也是人们发展的单位
 */
@Data
public class 门派 {
    private List<人> 门人;
    private Double 杂役;
    private Double 灵石;
    private List<山峰> 设施;
    private List<物品> 资源;
    private Double 庇护民众;
}
