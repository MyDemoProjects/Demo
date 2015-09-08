package org.zzc.server.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private Integer id;

    private Integer orderid;

    private Integer commodityid;

    private BigDecimal marketprice;

    private BigDecimal discountprice;

    private BigDecimal sumprice;

    private Integer purchasenum;

    private Integer paymethod;

    private Integer deliverymethod;

    private String returnremark;

    private BigDecimal returnmoney;

    private Date returntime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
    }

    public BigDecimal getSumprice() {
        return sumprice;
    }

    public void setSumprice(BigDecimal sumprice) {
        this.sumprice = sumprice;
    }

    public Integer getPurchasenum() {
        return purchasenum;
    }

    public void setPurchasenum(Integer purchasenum) {
        this.purchasenum = purchasenum;
    }

    public Integer getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(Integer paymethod) {
        this.paymethod = paymethod;
    }

    public Integer getDeliverymethod() {
        return deliverymethod;
    }

    public void setDeliverymethod(Integer deliverymethod) {
        this.deliverymethod = deliverymethod;
    }

    public String getReturnremark() {
        return returnremark;
    }

    public void setReturnremark(String returnremark) {
        this.returnremark = returnremark == null ? null : returnremark.trim();
    }

    public BigDecimal getReturnmoney() {
        return returnmoney;
    }

    public void setReturnmoney(BigDecimal returnmoney) {
        this.returnmoney = returnmoney;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }
}