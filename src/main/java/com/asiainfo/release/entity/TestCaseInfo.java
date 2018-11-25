package com.asiainfo.release.entity;

public class TestCaseInfo {
    private String testCaseName;
    private String downUrl;
    private String remarks;

    public TestCaseInfo(String testCaseName, String downUrl, String remarks) {
        this.testCaseName = testCaseName;
        this.downUrl = downUrl;
        this.remarks = remarks;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "TestCaseInfo{" +
                "testCaseName='" + testCaseName + '\'' +
                ", downUrl='" + downUrl + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
