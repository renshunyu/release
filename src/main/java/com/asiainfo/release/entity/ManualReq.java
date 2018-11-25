package com.asiainfo.release.entity;

import java.util.List;

public class ManualReq {
    private int productId;
    private List<ManualInfo> manualInfoList;

    public ManualReq(int productId, List<ManualInfo> manualInfoList) {
        this.productId = productId;
        this.manualInfoList = manualInfoList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<ManualInfo> getManualInfoList() {
        return manualInfoList;
    }

    public void setManualInfoList(List<ManualInfo> manualInfoList) {
        this.manualInfoList = manualInfoList;
    }

    @Override
    public String toString() {
        return "ManualReq{" +
                "productId=" + productId +
                ", manualInfoList=" + manualInfoList +
                '}';
    }
}
