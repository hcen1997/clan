package org.hcen.clan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hcen.clan.Util;
import org.hcen.clan.constant.Level;
import org.hcen.clan.constant.灵根类;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是基础智慧单位
 */
@Data
@AllArgsConstructor
public class 人 {

     @Deprecated
     private 人(){}

     private String name;
     private int age;
     private Level level;
     private long energy;
     private 灵根类 灵根;
     public static List<人> born(int n){
          if(n<=0){
               throw new RuntimeException("禁止负人");
          }
          List<人> ans = new ArrayList<>(n);
          for (int i = 0; i < n; i++) {
               人 人 = new 人(Util.randName(),
                       0, Level.randOne(),0, 灵根类.randOne());
          }
          return ans;
     }
}
