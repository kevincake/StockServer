package com.ifreedom.beauty.bean;

/**
 * @atuhor:eavawu
 * @date:10/12/2016
 * @todo:
 */
public class RealTimeStock {

    /**
     * symbol : sh603999
     * code : 603999
     * name : 读者传媒
     * trade : 32.070
     * pricechange : -2.480
     * changepercent : -7.178
     * buy : 32.090
     * sell : 32.100
     * settlement : 34.550
     * open : 33.700
     * high : 33.700
     * low : 31.540
     * volume : 11645026
     * amount : 378837875
     * ticktime : 15:00:00
     * per : 57.268
     * pb : 5.696
     * mktcap : 923616
     * nmc : 230904
     * turnoverratio : 16.17365
     */

    private String symbol;
    private String code;
    private String name;
    private double trade;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTrade() {
        return trade;
    }

    public void setTrade(double trade) {
        this.trade = trade;
    }

    public double getPricechange() {
        return pricechange;
    }

    public void setPricechange(double pricechange) {
        this.pricechange = pricechange;
    }

    public double getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(double changepercent) {
        this.changepercent = changepercent;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
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

    public String getTicktime() {
        return ticktime;
    }

    public void setTicktime(String ticktime) {
        this.ticktime = ticktime;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getMktcap() {
        return mktcap;
    }

    public void setMktcap(double mktcap) {
        this.mktcap = mktcap;
    }

    public double getNmc() {
        return nmc;
    }

    public void setNmc(double nmc) {
        this.nmc = nmc;
    }

    public double getTurnoverratio() {
        return turnoverratio;
    }

    public void setTurnoverratio(double turnoverratio) {
        this.turnoverratio = turnoverratio;
    }

    private double pricechange;
    private double changepercent;
    private double buy;
    private double sell;
    private String settlement;
    private double open;
    private double high;
    private double low;
    private double volume;
    private double amount;
    private String ticktime;
    private double per;
    private double pb;
    private double mktcap;
    private double nmc;
    private double turnoverratio;

}
