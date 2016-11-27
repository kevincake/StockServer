package com.ifreedom.beauty.bean;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:我的自选股主界面的查询信息
 */
public class MyStockQueryInfo {
    private String stockCode;
    private String stockName;
    private String precent;
    private String change;
    private String price;
    private String stockChannel;

    public String getStockChannel() {
        return stockChannel;
    }

    public void setStockChannel(String stockChannel) {
        this.stockChannel = stockChannel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getPrecent() {
        return precent;
    }

    public void setPrecent(String precent) {
        this.precent = precent;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "MyStockQueryInfo{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", precent='" + precent + '\'' +
                ", change='" + change + '\'' +
                ", price='" + price + '\'' +
                ", stockChannel='" + stockChannel + '\'' +
                '}';
    }
}
