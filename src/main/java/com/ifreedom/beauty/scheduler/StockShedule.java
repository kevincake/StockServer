package com.ifreedom.beauty.scheduler;

import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.iservice.IAllStockSerice;
import com.ifreedom.beauty.iservice.IStockService;
import com.ifreedom.beauty.service.AllStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @atuhor:eavawu
 * @date:04/12/2016
 * @todo:定时请求股票schedule
 */
@Component
public class StockShedule {
    @Autowired
    private AsyncWorker worker;


    @Autowired
    AllStockService allStockSerice;
    private final AtomicInteger counter = new AtomicInteger();


    @Scheduled(cron = "0 0/30 1-2 * * *")   //1-2点,半小时执行一次
    public void updateAllStock() {
        System.out.println("updateAllStock=====>begin");
        worker.work(new Runnable() {
            @Override
            public void run() {
                List<AllStockEntity> allStockInfoFromSJTL = HttpManager.getInstance().getAllStockInfoFromSJTL();
                allStockSerice.saveAll(allStockInfoFromSJTL);
                System.out.println("updateAllStock=====>success");
            }
        });
    }

    @Scheduled(cron = "0 0/30 1-2 * * *")
    public void notifyUsers(){

    }


}
