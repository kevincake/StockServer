package com.ifreedom.beauty.bean;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
public class NotifyInfo {
    private String title;
    private String tip;
    private String music;
    private String strategyId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public String toString() {
        return "NotifyInfo{" +
                "title='" + title + '\'' +
                ", tip='" + tip + '\'' +
                ", music='" + music + '\'' +
                ", strategyId='" + strategyId + '\'' +
                '}';
    }
}
