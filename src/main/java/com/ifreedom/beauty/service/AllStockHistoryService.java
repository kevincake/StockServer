package com.ifreedom.beauty.service;

import com.ifreedom.beauty.datacenter.DataManager;
import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.iservice.IAllStockHistoryService;
import com.ifreedom.beauty.iservice.IAllStockSerice;
import com.ifreedom.beauty.repository.AllStockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @atuhor:eavawu
 * @date:07/12/2016
 * @todo:所有股票历史的service
 */
@Service
public class AllStockHistoryService implements IAllStockHistoryService {
    @Autowired
    IAllStockSerice allStockSerice;
    @Autowired
    AllStockHistoryRepository allStockHistoryRepository;
    @Autowired
    DataManager dataManager;

    @Override
    public List<AllStockHistoryEntity> getAllStockHistoryFromNetwork() {
        List<AllStockHistoryEntity> list = new ArrayList<>();
        ConcurrentHashMap<String, AllStockEntity> allStockEntityMap = dataManager.getAllStockEntityMap();
        Iterator<Map.Entry<String, AllStockEntity>> iter = allStockEntityMap.entrySet().iterator();
        Map.Entry<String, AllStockEntity> entry;
        while (iter.hasNext()) {
            entry = iter.next();
            String key = entry.getKey();
            AllStockEntity value = entry.getValue();
            List<AllStockHistoryEntity> last = HttpManager.getOneStockAllHistory(value.getStockChannel(), value.getStockCode());
            list.addAll(last);
        }
        return list;

    }

    @Override
    public boolean saveAll(List<AllStockHistoryEntity> allStockHistory) {
        if (allStockHistory == null) {
            return false;
        }
        allStockHistoryRepository.saveAll(allStockHistory);
        return true;
    }

    @Override
    public List<AllStockHistoryEntity> getRecentstHistory(String code, int beginIndex, int count) {
        return allStockHistoryRepository.getRecentstHistory(code, beginIndex, count);
    }


}
