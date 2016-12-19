package com.ifreedom.beauty.util;

import com.ifreedom.beauty.bean.NotifyInfo;
import com.ifreedom.beauty.bean.RealTimeStock;
import com.ifreedom.beauty.datacenter.DataManager;
import com.ifreedom.beauty.entity.SMAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @atuhor:eavawu
 * @date:13/12/2016
 * @todo:
 */
public class NotifyUtil {

    public static void getNotifyInfoBySMA(List<RealTimeStock> realTimeStockList, ConcurrentHashMap<String, SMAEntity> smaDataMap) {
        List<NotifyInfo> notifyInfoList = new ArrayList<>();

        for (int i = 0; i < realTimeStockList.size(); i++) {

            RealTimeStock realTimeStock = realTimeStockList.get(i);
            String code = realTimeStock.getCode();
            double price = realTimeStock.getBuy();
            SMAEntity smaEntity = smaDataMap.get(code);
            if (smaEntity.getMa5() > price) {
                NotifyInfo notifyInfo = new NotifyInfo();

            }

            if (smaEntity.getMa10() > price) {

            }
            if (smaEntity.getMa20() > price) {

            }
            if (smaEntity.getMa30() > price) {

            }
            if (smaEntity.getMa60() > price) {

            }
            if (smaEntity.getMa120() > price) {

            }
            if (smaEntity.getMa240() > price) {

            }

        }

    }
}
