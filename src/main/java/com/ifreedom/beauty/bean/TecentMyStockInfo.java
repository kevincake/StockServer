package com.ifreedom.beauty.bean;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class TecentMyStockInfo {


    /**
     * code : 0
     * msg : ok
     * data : {"market_stat":{"hk":"close","sh":"close","sz":"close","us":"close","sq":"close","ds":"close","zs":"close"},"list":[{"tips":"0","code":"sz000001","isdelay":"0","state":"","sclx":"51","name":"平安银行","symbol":"000001","zxj":"9.62","zsj":"9.47","time":"20161125150133","zd":"0.15","zdf":"1.58","volume":"1013674","amount":"96813","hsl":"0.69","sz":"1651.79","type":"GP-A"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TecentMyStockInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "market_stat=" + market_stat +
                    ", list=" + list +
                    '}';
        }

        /**
         * market_stat : {"hk":"close","sh":"close","sz":"close","us":"close","sq":"close","ds":"close","zs":"close"}
         * list : [{"tips":"0","code":"sz000001","isdelay":"0","state":"","sclx":"51","name":"平安银行","symbol":"000001","zxj":"9.62","zsj":"9.47","time":"20161125150133","zd":"0.15","zdf":"1.58","volume":"1013674","amount":"96813","hsl":"0.69","sz":"1651.79","type":"GP-A"}]
         */

        private MarketStatBean market_stat;
        private List<ListBean> list;

        public MarketStatBean getMarket_stat() {
            return market_stat;
        }

        public void setMarket_stat(MarketStatBean market_stat) {
            this.market_stat = market_stat;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class MarketStatBean {
            /**
             * hk : close
             * sh : close
             * sz : close
             * us : close
             * sq : close
             * ds : close
             * zs : close
             */

            private String hk;
            private String sh;
            private String sz;
            private String us;
            private String sq;
            private String ds;
            private String zs;

            public String getHk() {
                return hk;
            }

            public void setHk(String hk) {
                this.hk = hk;
            }

            public String getSh() {
                return sh;
            }

            public void setSh(String sh) {
                this.sh = sh;
            }

            public String getSz() {
                return sz;
            }

            public void setSz(String sz) {
                this.sz = sz;
            }

            public String getUs() {
                return us;
            }

            public void setUs(String us) {
                this.us = us;
            }

            public String getSq() {
                return sq;
            }

            public void setSq(String sq) {
                this.sq = sq;
            }

            public String getDs() {
                return ds;
            }

            public void setDs(String ds) {
                this.ds = ds;
            }

            public String getZs() {
                return zs;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }
        }

        public static class ListBean {
            @Override
            public String toString() {
                return "ListBean{" +
                        "tips='" + tips + '\'' +
                        ", code='" + code + '\'' +
                        ", isdelay='" + isdelay + '\'' +
                        ", state='" + state + '\'' +
                        ", sclx='" + sclx + '\'' +
                        ", name='" + name + '\'' +
                        ", symbol='" + symbol + '\'' +
                        ", zxj='" + zxj + '\'' +
                        ", zsj='" + zsj + '\'' +
                        ", time='" + time + '\'' +
                        ", zd='" + zd + '\'' +
                        ", zdf='" + zdf + '\'' +
                        ", volume='" + volume + '\'' +
                        ", amount='" + amount + '\'' +
                        ", hsl='" + hsl + '\'' +
                        ", sz='" + sz + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }

            /**
             * tips : 0
             * code : sz000001
             * isdelay : 0
             * state :
             * sclx : 51
             * name : 平安银行
             * symbol : 000001
             * zxj : 9.62
             * zsj : 9.47
             * time : 20161125150133
             * zd : 0.15
             * zdf : 1.58
             * volume : 1013674
             * amount : 96813
             * hsl : 0.69
             * sz : 1651.79
             * type : GP-A
             */

            private String tips;
            private String code;
            private String isdelay;
            private String state;
            private String sclx;
            private String name;
            private String symbol;
            private String zxj;
            private String zsj;
            private String time;
            private String zd;
            private String zdf;
            private String volume;
            private String amount;
            private String hsl;
            private String sz;
            private String type;

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getIsdelay() {
                return isdelay;
            }

            public void setIsdelay(String isdelay) {
                this.isdelay = isdelay;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getSclx() {
                return sclx;
            }

            public void setSclx(String sclx) {
                this.sclx = sclx;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getZxj() {
                return zxj;
            }

            public void setZxj(String zxj) {
                this.zxj = zxj;
            }

            public String getZsj() {
                return zsj;
            }

            public void setZsj(String zsj) {
                this.zsj = zsj;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getZd() {
                return zd;
            }

            public void setZd(String zd) {
                this.zd = zd;
            }

            public String getZdf() {
                return zdf;
            }

            public void setZdf(String zdf) {
                this.zdf = zdf;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getHsl() {
                return hsl;
            }

            public void setHsl(String hsl) {
                this.hsl = hsl;
            }

            public String getSz() {
                return sz;
            }

            public void setSz(String sz) {
                this.sz = sz;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
