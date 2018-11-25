package com.asiainfo.release.entity;

import java.util.List;

public class TestCaseReq {
    private int productId;
    private List<TestCaseInfo> testCaseInfoList;

    public TestCaseReq(int productId, List<TestCaseInfo> testCaseInfoList) {
        this.productId = productId;
        this.testCaseInfoList = testCaseInfoList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<TestCaseInfo> getTestCaseInfoList() {
        return testCaseInfoList;
    }

    public void setTestCaseInfoList(List<TestCaseInfo> testCaseInfoList) {
        this.testCaseInfoList = testCaseInfoList;
    }

    @Override
    public String toString() {
        return "TestCaseReq{" +
                "productId=" + productId +
                ", testCaseInfoList=" + testCaseInfoList +
                '}';
    }
}
