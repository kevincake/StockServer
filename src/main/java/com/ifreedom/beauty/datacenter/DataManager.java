package com.ifreedom.beauty.datacenter;

import com.ifreedom.beauty.bean.RealTimeStock;
import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import com.ifreedom.beauty.entity.SMAEntity;
import com.ifreedom.beauty.entity.StrategyEntity;
import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.iservice.IMAService;
import com.ifreedom.beauty.iservice.IStrategyService;
import com.ifreedom.beauty.service.AllStockHistoryService;
import com.ifreedom.beauty.service.AllStockService;
import com.ifreedom.beauty.service.MAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @atuhor:eavawu
 * @date:04/12/2016
 * @todo:
 */
@Component
public class DataManager {
    @Autowired
    AllStockService iAllStockSerice;
    @Autowired
    AllStockHistoryService iAllHistoryService;
    @Autowired
    IMAService maService;
    @Autowired
    IStrategyService iStrategyService;

    public void load() {
        //加载所有股票信息
        List<AllStockEntity> allStock = HttpManager.getInstance().getAllStockInfoFromSJTL();
        iAllStockSerice.saveAll(allStock);
        //测试只获取两个数据
        if (allStock == null) {
            return;
        }
        for (int i = 0; i < allStock.size(); i++) {
            AllStockEntity allStockEntity = allStock.get(i);
            allStockEntityMap.put(allStockEntity.getStockCode(), allStockEntity);
        }

        //加载所有SMA
        List<SMAEntity> smaEntities = maService.getAll();
        for (int i = 0; i < smaEntities.size(); i++) {
            SMAEntity smaEntity = smaEntities.get(i);
            smaDataMap.put(smaEntity.getStockCode(), smaEntity);
        }

        //加载所有策略.code     List
        List<StrategyEntity> strategyEntityList = iStrategyService.getAll();
        for (int i = 0; i < strategyEntityList.size(); i++) {
            StrategyEntity strategyEntity = strategyEntityList.get(i);
            if (strategyDataMap.containsKey(strategyEntity.getStockCode())) {
                List<StrategyEntity> strategyEntitys = strategyDataMap.get(strategyEntity.getStockCode());
                strategyEntitys.add(strategyEntity);
            } else {
                List<StrategyEntity> strategyEntities = new ArrayList<>();
                strategyEntities.add(strategyEntity);
                strategyDataMap.put(strategyEntity.getStockCode(), strategyEntities);
            }
        }
    }

    public ConcurrentHashMap<String, AllStockEntity> getAllStockEntityMap() {
        return allStockEntityMap;
    }

    public void setAllStockEntityMap(ConcurrentHashMap<String, AllStockEntity> allStockEntityMap) {
        this.allStockEntityMap = allStockEntityMap;
    }

    public ConcurrentHashMap<String, AllStockHistoryEntity> getAllStockHistoryMap() {
        return allStockHistoryMap;
    }

    public void setAllStockHistoryMap(ConcurrentHashMap<String, AllStockHistoryEntity> allStockHistoryMap) {
        this.allStockHistoryMap = allStockHistoryMap;
    }

    public ConcurrentHashMap<String, SMAEntity> getSmaDataMap() {
        return smaDataMap;
    }

    public void setSmaDataMap(ConcurrentHashMap<String, SMAEntity> smaDataMap) {
        this.smaDataMap = smaDataMap;
    }

    public ConcurrentHashMap<String, List<StrategyEntity>> getStrategyDataMap() {
        return strategyDataMap;
    }

    public void setStrategyDataMap(ConcurrentHashMap<String, List<StrategyEntity>> strategyDataMap) {
        this.strategyDataMap = strategyDataMap;
    }

    private ConcurrentHashMap<String, AllStockEntity> allStockEntityMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AllStockHistoryEntity> allStockHistoryMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, RealTimeStock> allRealTimeStockMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, SMAEntity> smaDataMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<StrategyEntity>> strategyDataMap = new ConcurrentHashMap<>();


}
