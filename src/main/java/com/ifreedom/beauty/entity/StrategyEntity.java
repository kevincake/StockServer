package com.ifreedom.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @atuhor:eavawu
 * @date:11/12/2016
 * @todo:
 */
@Entity
@Table(name = "strategy")
public class StrategyEntity {
    @Id
    private long id;
    private long userId;
    //股票代码
    private String stockCode;
    //股票渠道
    private String channel;
    //策略提醒是否打开
    private int isOpen;
    //策略提醒间隔
    private long timeLimit;
    //上次提醒的时间
    private long lastTime;
    //音乐
    private String music;
    //提醒
    private String tip;
    //策略类型
    private int strategyType;
    //策略信息
    private String strategyInfo;
    //策略名字
    private String strategyName;

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
    }

    public String getStrategyInfo() {
        return strategyInfo;
    }

    public void setStrategyInfo(String strategyInfo) {
        this.strategyInfo = strategyInfo;
    }
}
