package com.ifreedom.beauty.bean.strategy.price;

import com.ifreedom.beauty.bean.strategy.StrategyItem;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
public class PriceStrategy extends StrategyItem {
    public static final int LOW = 1;
    public static final int HIGH = 2;
    private double price;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
