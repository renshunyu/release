package com.asiainfo.release.entity;

import java.util.List;

public class ChangeDescriptionReq {
    private int productId;
    private List<ChangeDescriptionInfo> changeDescriptionInfoList;

    public ChangeDescriptionReq(int productId, List<ChangeDescriptionInfo> changeDescriptionInfoList) {
        this.productId = productId;
        this.changeDescriptionInfoList = changeDescriptionInfoList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<ChangeDescriptionInfo> getChangeDescriptionInfoList() {
        return changeDescriptionInfoList;
    }

    public void setChangeDescriptionInfoList(List<ChangeDescriptionInfo> changeDescriptionInfoList) {
        this.changeDescriptionInfoList = changeDescriptionInfoList;
    }

    @Override
    public String toString() {
        return "ChangeDescriptionReq{" +
                "productId=" + productId +
                ", changeDescriptionInfoList=" + changeDescriptionInfoList +
                '}';
    }
}
