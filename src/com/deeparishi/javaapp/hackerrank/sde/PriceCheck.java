package com.deeparishi.javaapp.hackerrank.sde;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCheck {

    public static int priceCheck(List<String> products, List<Float> productPrices,
                                 List<String> productSold, List<Float> soldPrice) {

        if (products.size() != productPrices.size() && productSold.size() != soldPrice.size())
            return 0;


        Map<String, Float> priceChart = new HashMap<>();

        for (int i = 0; i < products.size(); i++) {
            priceChart.put(products.get(i), productPrices.get(i));
        }

        int count = 0;

        for(int i=0; i < productSold.size(); i++){
            Float soldprice = soldPrice.get(i);
            Float actualPrice = priceChart.get(productSold.get(i));
            float epsilon = 0.0001f;

            if(Math.abs(soldprice - actualPrice) > epsilon)
                count++;
        }

        return count;
    }
}
