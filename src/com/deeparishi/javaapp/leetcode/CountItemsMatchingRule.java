package com.deeparishi.javaapp.leetcode;

import java.util.List;
import java.util.Locale;

public class CountItemsMatchingRule {
    public static void main(String[] args) {
        List<List<String>> list = List.of(
                List.of("phone","blue","pixel"),
                List.of("computer","silver","lenovo"),
                List.of("phone","gold","iphone")
        );

        int u = 0^3;

        System.out.println(u);

    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;

        //1 - > Type, 2-> color, 3-> name
        int typeNum = 0;

        if(ruleKey.toLowerCase() == "type"){
            typeNum = 1;
        }else if(ruleKey.toLowerCase() == "color"){
            typeNum = 2;
        }else if(ruleKey.toLowerCase() == "name"){
            typeNum =3;
        }

        for(List<String> listOfItem : items){
            if(typeNum==1){
                int scene = listOfItem.get(0) == ruleValue ? result++ : result ;
            }
            if(typeNum==2){
                int scene = listOfItem.get(1) == ruleValue ? result++ : result ;
            }
            if(typeNum==3){
                int scene = listOfItem.get(2) == ruleValue ? result++ : result ;
            }
        }
        return result;
    }


}
