package com.ifreedom.beauty.bean;

import java.util.List;

/**
 * Created by HomorSmith on 2016/12/5.
 */
public class SJTLAllStock {

    /**
     * retCode : 1
     * retMsg : Success
     * data : [{"secID":"000001.XSHE","ticker":"000001","exchangeCD":"XSHE","ListSectorCD":1,"ListSector":"主板","transCurrCD":"CNY","secShortName":"平安银行","secFullName":"平安银行股份有限公司","listStatusCD":"L","listDate":"1991-04-03","equTypeCD":"A","equType":"沪深A股","exCountryCD":"CHN","partyID":2,"totalShares":17170411400,"nonrestFloatShares":14631180400,"nonrestfloatA":14631180400,"officeAddr":"广东省深圳市罗湖区深南东路5047号","primeOperating":"(一)吸收公众存款；(二)发放短期、中期和长期贷款；(三)办理国内外结算；(四)办理票据承兑与贴现；(五)发行金融债券；(六)代理发行、代理兑付、承销政府债券；(七)买卖政府债券、金融债券；(八)从事同业拆借；(九)买卖、代理买卖外汇；(十)从事银行卡业务；(十一)提供信用证服务及担保；(十二)代理收付款项及代理保险业务；(十三)提供保管箱服务；(十四)结汇、售汇业务；(十五)离岸银行业务；(十六)资产托管业务；(十七)办理黄金业务；(十八)财务顾问、资信调查、咨询、见证业务；(十九)经有关监管机构批准的其他业务。","endDate":"2016-09-30","TShEquity":198228000000}]
     */

    private int retCode;
    private String retMsg;
    private List<DataBean> data;

    public int getRetCode() {
        return retCode;
    }

    @Override
    public String toString() {
        return "SJTLAllStock{" +
                "retCode=" + retCode +
                ", retMsg='" + retMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * secID : 000001.XSHE
         * ticker : 000001
         * exchangeCD : XSHE
         * ListSectorCD : 1
         * ListSector : 主板
         * transCurrCD : CNY
         * secShortName : 平安银行
         * secFullName : 平安银行股份有限公司
         * listStatusCD : L
         * listDate : 1991-04-03
         * equTypeCD : A
         * equType : 沪深A股
         * exCountryCD : CHN
         * partyID : 2
         * totalShares : 17170411400
         * nonrestFloatShares : 14631180400
         * nonrestfloatA : 14631180400
         * officeAddr : 广东省深圳市罗湖区深南东路5047号
         * primeOperating : (一)吸收公众存款；(二)发放短期、中期和长期贷款；(三)办理国内外结算；(四)办理票据承兑与贴现；(五)发行金融债券；(六)代理发行、代理兑付、承销政府债券；(七)买卖政府债券、金融债券；(八)从事同业拆借；(九)买卖、代理买卖外汇；(十)从事银行卡业务；(十一)提供信用证服务及担保；(十二)代理收付款项及代理保险业务；(十三)提供保管箱服务；(十四)结汇、售汇业务；(十五)离岸银行业务；(十六)资产托管业务；(十七)办理黄金业务；(十八)财务顾问、资信调查、咨询、见证业务；(十九)经有关监管机构批准的其他业务。
         * endDate : 2016-09-30
         * TShEquity : 198228000000
         */

        private String secID;
        private String ticker;
        private String exchangeCD;
        private int ListSectorCD;
        private String ListSector;
        private String transCurrCD;
        private String secShortName;
        private String secFullName;
        private String listStatusCD;
        private String listDate;
        private String equTypeCD;
        private String equType;
        private String exCountryCD;
        private int partyID;
        private long totalShares;
        private long nonrestFloatShares;
        private long nonrestfloatA;
        private String officeAddr;
        private String primeOperating;
        private String endDate;
        private double TShEquity;

        public String getSecID() {
            return secID;
        }

        public void setSecID(String secID) {
            this.secID = secID;
        }

        public String getTicker() {
            return ticker;
        }

        public void setTicker(String ticker) {
            this.ticker = ticker;
        }

        public String getExchangeCD() {
            return exchangeCD;
        }

        public void setExchangeCD(String exchangeCD) {
            this.exchangeCD = exchangeCD;
        }

        public int getListSectorCD() {
            return ListSectorCD;
        }

        public void setListSectorCD(int ListSectorCD) {
            this.ListSectorCD = ListSectorCD;
        }

        public String getListSector() {
            return ListSector;
        }

        public void setListSector(String ListSector) {
            this.ListSector = ListSector;
        }

        public String getTransCurrCD() {
            return transCurrCD;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "secID='" + secID + '\'' +
                    ", ticker='" + ticker + '\'' +
                    ", exchangeCD='" + exchangeCD + '\'' +
                    ", ListSectorCD=" + ListSectorCD +
                    ", ListSector='" + ListSector + '\'' +
                    ", transCurrCD='" + transCurrCD + '\'' +
                    ", secShortName='" + secShortName + '\'' +
                    ", secFullName='" + secFullName + '\'' +
                    ", listStatusCD='" + listStatusCD + '\'' +
                    ", listDate='" + listDate + '\'' +
                    ", equTypeCD='" + equTypeCD + '\'' +
                    ", equType='" + equType + '\'' +
                    ", exCountryCD='" + exCountryCD + '\'' +
                    ", partyID=" + partyID +
                    ", totalShares=" + totalShares +
                    ", nonrestFloatShares=" + nonrestFloatShares +
                    ", nonrestfloatA=" + nonrestfloatA +
                    ", officeAddr='" + officeAddr + '\'' +
                    ", primeOperating='" + primeOperating + '\'' +
                    ", endDate='" + endDate + '\'' +
                    ", TShEquity=" + TShEquity +
                    '}';
        }

        public void setTransCurrCD(String transCurrCD) {
            this.transCurrCD = transCurrCD;
        }

        public String getSecShortName() {
            return secShortName;
        }

        public void setSecShortName(String secShortName) {
            this.secShortName = secShortName;
        }

        public String getSecFullName() {
            return secFullName;
        }

        public void setSecFullName(String secFullName) {
            this.secFullName = secFullName;
        }

        public String getListStatusCD() {
            return listStatusCD;
        }

        public void setListStatusCD(String listStatusCD) {
            this.listStatusCD = listStatusCD;
        }

        public String getListDate() {
            return listDate;
        }

        public void setListDate(String listDate) {
            this.listDate = listDate;
        }

        public String getEquTypeCD() {
            return equTypeCD;
        }

        public void setEquTypeCD(String equTypeCD) {
            this.equTypeCD = equTypeCD;
        }

        public String getEquType() {
            return equType;
        }

        public void setEquType(String equType) {
            this.equType = equType;
        }

        public String getExCountryCD() {
            return exCountryCD;
        }

        public void setExCountryCD(String exCountryCD) {
            this.exCountryCD = exCountryCD;
        }

        public int getPartyID() {
            return partyID;
        }

        public void setPartyID(int partyID) {
            this.partyID = partyID;
        }

        public long getTotalShares() {
            return totalShares;
        }

        public void setTotalShares(long totalShares) {
            this.totalShares = totalShares;
        }

        public long getNonrestFloatShares() {
            return nonrestFloatShares;
        }

        public void setNonrestFloatShares(long nonrestFloatShares) {
            this.nonrestFloatShares = nonrestFloatShares;
        }

        public long getNonrestfloatA() {
            return nonrestfloatA;
        }

        public void setNonrestfloatA(long nonrestfloatA) {
            this.nonrestfloatA = nonrestfloatA;
        }

        public String getOfficeAddr() {
            return officeAddr;
        }

        public void setOfficeAddr(String officeAddr) {
            this.officeAddr = officeAddr;
        }

        public String getPrimeOperating() {
            return primeOperating;
        }

        public void setPrimeOperating(String primeOperating) {
            this.primeOperating = primeOperating;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public double getTShEquity() {
            return TShEquity;
        }

        public void setTShEquity(long TShEquity) {
            this.TShEquity = TShEquity;
        }
    }
}
