package com.ifreedom.beauty.bean.strategy.ma;

import com.ifreedom.beauty.bean.strategy.StrategyItem;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
public class Ma extends StrategyItem {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static final int LOW = 1;
    public static final int HIGH = 2;
}
