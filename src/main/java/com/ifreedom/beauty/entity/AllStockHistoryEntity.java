package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:06/12/2016
 * @todo:
 */
@Entity
@Table(name = "all_stock_history")
public class AllStockHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String stockCode;
    private String stockChannel;
    private String date;
    private double open;
    private double high;
    private double close;
    private double low;
    private double volume;
    private double amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockChannel() {
        return stockChannel;
    }

    public void setStockChannel(String stockChannel) {
        this.stockChannel = stockChannel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AllStockHistoryEntity{" +
                "id=" + id +
                ", stockCode='" + stockCode + '\'' +
                ", stockChannel='" + stockChannel + '\'' +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", close=" + close +
                ", low=" + low +
                ", volume=" + volume +
                ", amount=" + amount +
                '}';
    }
}
