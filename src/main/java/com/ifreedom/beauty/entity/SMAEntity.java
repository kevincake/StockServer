package com.ifreedom.beauty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @atuhor:eavawu
 * @date:11/12/2016
 * @todo:单只股票所有的移动均线
 */
@Entity
@Table(name = "sma")
public class SMAEntity {
    private String channel;
    @Id
    private String stockCode;
    private double ma5;
    private double ma10;
    private double ma20;
    private double ma30;
    private double ma60;
    private double ma120;
    private double ma240;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getMa5() {
        return ma5;
    }

    public void setMa5(double ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(double ma10) {
        this.ma10 = ma10;
    }

    public double getMa20() {
        return ma20;
    }

    public void setMa20(double ma20) {
        this.ma20 = ma20;
    }

    public double getMa30() {
        return ma30;
    }

    public void setMa30(double ma30) {
        this.ma30 = ma30;
    }

    public double getMa60() {
        return ma60;
    }

    public void setMa60(double ma60) {
        this.ma60 = ma60;
    }

    public double getMa120() {
        return ma120;
    }

    public void setMa120(double ma120) {
        this.ma120 = ma120;
    }

    public double getMa240() {
        return ma240;
    }

    public void setMa240(double ma240) {
        this.ma240 = ma240;
    }
}
