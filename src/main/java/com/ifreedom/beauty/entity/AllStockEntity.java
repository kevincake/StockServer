package com.ifreedom.beauty.entity;

import javax.persistence.*;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:所有股票的实体类
 */
@Entity
@Table(name = "all_stock")
public class AllStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//主键
    private String stockCode;
    private String stockName;
    private String stockChannel;
    private String toMaketDate;

    public String getToMaketDate() {
        return toMaketDate;
    }

    public void setToMaketDate(String toMaketDate) {
        this.toMaketDate = toMaketDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockChannel() {
        return stockChannel;
    }

    public void setStockChannel(String stockChannel) {
        this.stockChannel = stockChannel;
    }

    @Override
    public String toString() {
        return "AllStockEntity{" +
                "id=" + id +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockChannel='" + stockChannel + '\'' +
                ", toMaketDate='" + toMaketDate + '\'' +
                '}';
    }
}
