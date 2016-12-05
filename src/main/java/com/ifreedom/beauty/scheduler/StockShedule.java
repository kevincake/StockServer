package com.ifreedom.beauty.scheduler;

import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.iservice.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    IStockService stockService;
    private final AtomicInteger counter = new AtomicInteger();

    @Scheduled(fixedRate = 3000, initialDelay = 1 * 1000)
    public void report1() {
        for (int i = 0; i < 10; i++) {
            worker.work("reportCurrentTime1 - " + counter.incrementAndGet());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
            }
        }
    }

    @Scheduled(fixedRate = 3000, initialDelay = 1 * 1000)
    public void report2() {
        for (int i = 0; i < 10; i++) {
            worker.work("reportCurrentTime2 - " + counter.incrementAndGet());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
            }
        }
    }


    @Scheduled(fixedRate = 3000, initialDelay = 1 * 1000)
    public void getRealTimeStock(){
        worker.work(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
