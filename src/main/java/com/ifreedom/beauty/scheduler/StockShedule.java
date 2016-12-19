package com.ifreedom.beauty.scheduler;

import com.google.gson.Gson;
import com.ifreedom.beauty.bean.NotifyInfo;
import com.ifreedom.beauty.bean.RealTimeStock;
import com.ifreedom.beauty.bean.strategy.ma.*;
import com.ifreedom.beauty.bean.strategy.price.PriceStrategy;
import com.ifreedom.beauty.constants.StrategyConstants;
import com.ifreedom.beauty.datacenter.DataManager;
import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import com.ifreedom.beauty.entity.SMAEntity;
import com.ifreedom.beauty.entity.StrategyEntity;
import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.http.impl.SinaLogic;
import com.ifreedom.beauty.service.AllStockHistoryService;
import com.ifreedom.beauty.service.AllStockService;
import com.ifreedom.beauty.service.MAService;
import com.ifreedom.beauty.util.LogUtil;
import com.ifreedom.beauty.util.MAUtil;
import com.ifreedom.beauty.util.PropertyUtil;
import com.ifreedom.beauty.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
    DataManager dataManager;
    @Autowired
    AllStockHistoryService allStockHistoryService;
    @Autowired
    MAService maService;
    @Autowired
    AllStockService allStockSerice;
    private Gson gson = new Gson();
    private final AtomicInteger counter = new AtomicInteger();


    @Scheduled(cron = "0 0/30 11-12 * * *")   //1-2点,半小时执行一次
    public void updateAllStock() {
        LogUtil.info("updateAllStock=====>begin", "begin");
        worker.work(new Runnable() {
            @Override
            public void run() {
                List<AllStockEntity> allStockInfoFromSJTL = HttpManager.getInstance().getAllStockInfoFromSJTL();
                allStockSerice.saveAll(allStockInfoFromSJTL);
                System.out.println("updateAllStock=====>success");
            }
        });
    }

//    @Scheduled(cron = "0 0/30 1-2 * * *")
//    public void notifyUsers() {
//
//    }

//    @Scheduled(cron = "0 0/2 * * * *")
//    public void load() {
//        dataManager.load();
//    }


    @Scheduled(cron = "0 0/30 * * * *")
    public void updateStockHistory() {
        System.out.println("updateStockHistory=====>begin");
    }

    //更新SMA,四点到五点更新一次
    @Scheduled(cron = "0 0 4-5 * * * ")
    public void updateSMA() {
        worker.work(new Runnable() {
            @Override
            public void run() {
                List<AllStockEntity> allStock = allStockSerice.getAllStock();
                for (int i = 0; i < allStock.size(); i++) {
                    AllStockEntity allStockEntity = allStock.get(i);
                    List<AllStockHistoryEntity> MA240List = allStockHistoryService.getRecentstHistory(allStockEntity.getStockCode(), 0, 240);
                    if (MA240List.size() <= 0) {
                        continue;
                    }
                    List<AllStockHistoryEntity> MA5List = null;
                    List<AllStockHistoryEntity> MA10List = null;
                    List<AllStockHistoryEntity> MA15List = null;
                    List<AllStockHistoryEntity> MA20List = null;
                    List<AllStockHistoryEntity> MA30List = null;
                    List<AllStockHistoryEntity> MA60List = null;
                    List<AllStockHistoryEntity> MA120List = null;
                    if (MA240List.size() > 5) {
                        MA5List = MA240List.subList(0, 5 - 1);
                    }
                    if (MA240List.size() > 10) {
                        MA10List = MA240List.subList(0, 10 - 1);
                    }

                    if (MA240List.size() > 15) {
                        MA15List = MA240List.subList(0, 15 - 1);
                    }

                    if (MA240List.size() > 20) {
                        MA20List = MA240List.subList(0, 20 - 1);
                    }

                    if (MA240List.size() > 30) {
                        MA30List = MA240List.subList(0, 30 - 1);
                    }

                    if (MA240List.size() > 60) {
                        MA60List = MA240List.subList(0, 60 - 1);
                    }

                    if (MA240List.size() > 120) {
                        MA120List = MA240List.subList(0, 120 - 1);
                    }
                    if (MA240List.size() > 120) {
                        MA240List = MA240List.subList(0, 120 - 1);
                    }
                    SMAEntity smaEntity = new SMAEntity();
                    smaEntity.setMa5(MAUtil.sma(MA5List));
                    smaEntity.setMa10(MAUtil.sma(MA10List));
                    smaEntity.setMa20(MAUtil.sma(MA20List));
                    smaEntity.setMa30(MAUtil.sma(MA30List));
                    smaEntity.setMa60(MAUtil.sma(MA60List));
                    smaEntity.setMa120(MAUtil.sma(MA120List));
                    smaEntity.setMa240(MAUtil.sma(MA240List));
                    smaEntity.setChannel(allStockEntity.getStockChannel());
                    smaEntity.setStockCode(allStockEntity.getStockCode());
                    maService.saveSMA(smaEntity);
                }
            }
        });
    }

    @Scheduled(cron = "0/20 * * * * *")
    public void updateRealTimeStock() {
        LogUtil.info("updateRealTimeStock====>", "begin");
        int pageSize = dataManager.getAllStockEntityMap().size();
        if (pageSize <= 0) {
            dataManager.load();
            return;
        }
        ConcurrentHashMap<String, List<StrategyEntity>> strategyDataMap = dataManager.getStrategyDataMap();
        ConcurrentHashMap<String, SMAEntity> smaDataMap = dataManager.getSmaDataMap();
        SinaLogic.getRealTimeStock(1, pageSize, new Callback<List<RealTimeStock>>() {
            @Override
            public void onResponse(Call<List<RealTimeStock>> call, Response<List<RealTimeStock>> response) {
                //执行策略
                LogUtil.info("updateRealTimeStock====>", "data");
                List<RealTimeStock> realTimeStocks = response.body();
                for (int i = 0; i < realTimeStocks.size(); i++) {
                    RealTimeStock realTimeStock = realTimeStocks.get(i);
                    double price = realTimeStock.getBuy();
                    String code = realTimeStock.getCode();
                    //获取SMA
                    SMAEntity smaEntity = smaDataMap.get(code);
                    //一个code对应的所有策略,策略对比
                    List<StrategyEntity> strategyEntityList = strategyDataMap.get(code);
                    if (smaEntity==null)continue;
                    if (strategyEntityList==null)continue;
                    //所有notifyInfo的list
                    List<NotifyInfo> notifyInfoList = new ArrayList<NotifyInfo>();
                    //对比ma
                    for (int j = 0; j < strategyEntityList.size(); j++) {
                        StrategyEntity strategyEntity = strategyEntityList.get(j);
                        if (strategyEntity.getIsOpen() == 1) { //策略开启
                            int strategyType = strategyEntity.getStrategyType(); //策略类型
                            NotifyInfo notifyInfo = null;
                            String strategyInfo = strategyEntity.getStrategyInfo();
                            switch (strategyType) {
                                case StrategyConstants.PRICE:

                                    PriceStrategy priceStrategy = gson.fromJson(strategyInfo, PriceStrategy.class);
                                    double sPrice = priceStrategy.getPrice();
                                    if (sPrice < price&&priceStrategy.getType()==PriceStrategy.HIGH) { //当前价格高于策略价格
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ PropertyUtil.getProperty("price_high_than")+priceStrategy.getPrice(),strategyEntity);
                                    }
                                    if (sPrice > price&&priceStrategy.getType()==PriceStrategy.LOW){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+PropertyUtil.getProperty("price_low_than")+priceStrategy.getPrice(),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA5:
                                    Ma5 ma5 = gson.fromJson(strategyInfo,Ma5.class);
                                    if (ma5.getType() == Ma.LOW&&smaEntity.getMa5()<price){ //低于五日均线
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("5",smaEntity.getMa5()),strategyEntity);
                                    }else if(ma5.getType() == Ma.HIGH&&smaEntity.getMa5()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("5",smaEntity.getMa5()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA10:
                                    Ma10 ma10 = gson.fromJson(strategyInfo,Ma10.class);
                                    if (ma10.getType() == Ma.LOW&&smaEntity.getMa5()<price){ //低于十日均线
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("10",smaEntity.getMa10()),strategyEntity);
                                    }else if(ma10.getType() == Ma.HIGH&&smaEntity.getMa10()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("10",smaEntity.getMa10()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA20:
                                    Ma20 ma15 = gson.fromJson(strategyInfo,Ma20.class);
                                    if (ma15.getType() == Ma.LOW&&smaEntity.getMa5()<price){ //低于二十日均线
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("20",smaEntity.getMa20()),strategyEntity);
                                    }else if(ma15.getType() == Ma.HIGH&&smaEntity.getMa20()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("20",smaEntity.getMa20()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA30:
                                    Ma30 ma30 = gson.fromJson(strategyInfo,Ma30.class);
                                    if (ma30.getType() == Ma.LOW&&smaEntity.getMa30()<price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("30",smaEntity.getMa30()),strategyEntity);
                                    }else if(ma30.getType() == Ma.HIGH&&smaEntity.getMa30()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("30",smaEntity.getMa30()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA60:
                                    Ma60 ma60 = gson.fromJson(strategyInfo,Ma60.class);
                                    if (ma60.getType() == Ma.LOW&&smaEntity.getMa60()<price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("60",smaEntity.getMa60()),strategyEntity);
                                    }else if(ma60.getType() == Ma.HIGH&&smaEntity.getMa30()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("60",smaEntity.getMa60()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA120:
                                    Ma120 ma120 = gson.fromJson(strategyInfo,Ma120.class);
                                    if (ma120.getType() == Ma.LOW&&smaEntity.getMa120()<price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("120",smaEntity.getMa120()),strategyEntity);
                                    }else if(ma120.getType() == Ma.HIGH&&smaEntity.getMa120()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("120",smaEntity.getMa120()),strategyEntity);
                                    }
                                    break;
                                case StrategyConstants.MA240:
                                    Ma240 ma240 = gson.fromJson(strategyInfo,Ma240.class);
                                    if (ma240.getType() == Ma.LOW&&smaEntity.getMa240()<price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getHighPriceStr("240",smaEntity.getMa240()),strategyEntity);
                                    }else if(ma240.getType() == Ma.HIGH&&smaEntity.getMa240()>price){
                                        notifyInfo = getNotifyInfo(realTimeStock.getName()+ StringUtils.getLowPriceStr("240",smaEntity.getMa240()),strategyEntity);
                                    }
                                    break;
                            }

                            if (notifyInfo!=null){
                                notifyInfoList.add(notifyInfo);
                                System.out.println("<======notify_info======>"+notifyInfo.toString());
                                break;
                            }
                        }



                    }


                }

            }

            @Override
            public void onFailure(Call<List<RealTimeStock>> call, Throwable throwable) {
                LogUtil.info("updateRealTimeStock====>", "exception:" + throwable.toString());
            }
        });
    }



    private NotifyInfo getNotifyInfo(String tip,StrategyEntity strategyEntity){
        NotifyInfo  notifyInfo = new NotifyInfo();
        notifyInfo.setTitle(tip);
        notifyInfo.setStrategyId(strategyEntity.getId() + "");
        notifyInfo.setTip(strategyEntity.getTip());
        notifyInfo.setMusic(strategyEntity.getMusic());
        return notifyInfo;
    }


}
