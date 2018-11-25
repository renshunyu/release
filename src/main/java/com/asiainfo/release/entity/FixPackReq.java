package com.asiainfo.release.entity;

import java.util.List;

public class FixPackReq {
    private int productId;
    private List<FixPackInfo> fixPackInfoList;

    public FixPackReq(int productId, List<FixPackInfo> fixPackInfoList) {
        this.productId = productId;
        this.fixPackInfoList = fixPackInfoList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<FixPackInfo> getFixPackInfoList() {
        return fixPackInfoList;
    }

    public void setFixPackInfoList(List<FixPackInfo> fixPackInfoList) {
        this.fixPackInfoList = fixPackInfoList;
    }

    @Override
    public String toString() {
        return "FixPackReq{" +
                "productId=" + productId +
                ", fixPackInfoList=" + fixPackInfoList +
                '}';
    }
}
