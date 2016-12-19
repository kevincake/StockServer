package com.ifreedom.beauty.util;

import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
public class MAUtil {
    public static double sma(List<AllStockHistoryEntity> allStockHistoryList) {
        if (allStockHistoryList==null||allStockHistoryList.size() <= 0){
            return -1;
        }
        double maTotal = 0;
        for (int i = 0; i < allStockHistoryList.size(); i++) {
            maTotal = maTotal + allStockHistoryList.get(i).getClose();
        }

        return maTotal / allStockHistoryList.size();
    }
}
